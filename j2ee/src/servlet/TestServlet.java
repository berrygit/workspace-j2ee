package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.StringTools;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		testSession(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		testApplication(req);
	}

	/**
	 * pageRedirect 页面跳转
	 *
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	protected void pageRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 重定向
		resp.sendRedirect("/WEB-INF/result/fail.jsp");

		// forward
		getServletConfig().getServletContext().getRequestDispatcher("/test/login").forward(req, resp);
	}

	/**
	 * testApplication 测试Application
	 *
	 * @param req
	 */
	protected void testApplication(HttpServletRequest req) {
		ServletContext sc = req.getServletContext();

		Integer count = (Integer) sc.getAttribute("count");

		if (count == null) {
			count = new Integer(0);
		}

		System.out.println(count++);
		sc.setAttribute("count", count);
	}

	/**
	 * testSession 测试session
	 *
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	protected void testSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);

		System.out.println(session.getId());

		Integer count = (Integer) session.getAttribute("count");

		if (count == null) {
			count = new Integer(0);
		}

		System.out.println(count++);
		session.setAttribute("count", count);

		/*
		 * PrintWriter pw = resp.getWriter(); String uri =
		 * "/test/login"; String encodeUri =
		 * resp.encodeURL(uri);// encode同时追加sessionID pw.write(
		 * "<!DOCTYPE HTML><html lang=\"en\"><head><meta charset=\"UTF-8\"></head><body>"
		 * ); pw.write("<a href=" + uri + ">cookie刷新</a><br>");
		 * pw.write("<a href=" + encodeUri + ">url重写刷新</a>");
		 * pw.write("</body></html>");
		 */
	}

	/**
	 * testCookie 测试cookie
	 *
	 * @param req
	 * @param resp
	 */
	protected void testCookie(HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cs = req.getCookies();

		if (cs != null) {
			for (Cookie c : cs) {
				System.out.println(c.getName() + " " + c.getValue());
			}
		}

		Cookie userNameCookie = new Cookie("userName", "berry");
		userNameCookie.setMaxAge(3600);
		Cookie sexCookie = new Cookie("sex", "Male");
		Cookie passWordCookie = new Cookie("passWord", "123456");
		passWordCookie.setPath("/pp");

		// 域名，用来实现跨站
		passWordCookie.setDomain("baidu.com");

		resp.addCookie(userNameCookie);
		resp.addCookie(sexCookie);
		resp.addCookie(passWordCookie);
	}

	/**
	 * responsePicToClient 向浏览器响应图片文件
	 *
	 * @param resp
	 * @throws IOException
	 */
	protected void responsePicToClient(HttpServletResponse resp) throws IOException {
		String path = getServletContext().getRealPath("/");
		String fileName = "How fast.ogg";
		File file = new File(path + fileName);

		int length = (int) file.length();
		byte[] b = new byte[length];

		FileInputStream fi = new FileInputStream(file);
		fi.read(b, 0, length);
		fi.close();

		ServletOutputStream so = resp.getOutputStream();
		so.write(b);
		so.flush();
	}

	/**
	 * printPostBodyInfoByReader 通过Reader读取Post消息体
	 *
	 * @param req
	 * @throws IOException
	 */
	protected void printPostBodyInfoByReader(HttpServletRequest req) throws IOException {
		BufferedReader r = req.getReader();
		String message = r.readLine();

		if (StringTools.isNullOrNone(message)) {
			System.out.println(URLDecoder.decode(message, "utf-8"));
		}
	}

	/**
	 * printPostBodyInfoByInputStream 通过InputStream流获取POST的消息体
	 *
	 * @param req
	 * @throws IOException
	 */
	protected void printPostBodyInfoByInputStream(HttpServletRequest req) throws IOException {
		// 打印输出post的报文
		int i = req.getContentLength();
		ServletInputStream in = req.getInputStream();
		byte[] b = new byte[i];
		System.out.println(in.readLine(b, 0, i));

		for (byte dd : b) {
			System.out.print((char) dd);
		}
	}

	/**
	 * printRequestInfo打印请求信息
	 *
	 * @param req
	 */
	protected void printRequestInfo(HttpServletRequest req) {
		Method[] method = req.getClass().getMethods();
		for (Method m : method) {
			if ((m.getParameterTypes().length == 0) && (m.getReturnType() != null)) {
				System.out.println(m.getName());
				try {
					System.out.println(m.invoke(req, (Object[]) null));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
			}
		}
	}
}
