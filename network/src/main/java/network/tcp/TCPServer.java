package network.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class TCPServer {

	public static Map<String, Object> services = new HashMap<String, Object>();

	public TCPServer() {
		services.put("SayHelloService", new SayHelloServiceImpl());
	}

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(1234);

		while (true) {
			Socket socket = ss.accept();

			ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
			String interfaceName = oi.readUTF();
			String methodName = oi.readUTF();
			Class<?>[] parameterTypes = (Class<?>[]) oi.readObject();
			Object[] arguments = (Object[]) oi.readObject();

			Class<?> serviceInterfaceClass = Class.forName(interfaceName);
			// 此处应该根据接口获取实现类，这里为了简便用了接口
			Object service = serviceInterfaceClass.newInstance();
			Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);

			Object result = method.invoke(service, arguments);

			ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
			oo.writeObject(result);
		}
	}
}
