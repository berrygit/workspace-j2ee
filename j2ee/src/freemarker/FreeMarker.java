package freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarker
{
	public static void main(String[] args) throws IOException,
			TemplateException
	{
		// 模板路径
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File("src/freemarker/"));

		// 加载模板
		Template template = cfg.getTemplate("hello.ftl");

		// 创建对象
		Map<String, String> root = new HashMap<String, String>();
		root.put("user", "LiMing");

		// 根据对象和模板输出
		Writer out = new OutputStreamWriter(System.out);
		template.process(root, out);
		out.close();

	}
}
