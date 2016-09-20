package spring;

import org.junit.Test;

public class SpringTest
{

	// @Test
	public final void testXMLSetter()
	{
		@SuppressWarnings("resource")
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/beans.xml");

		UserService userService = applicationContext.getBean("userService",
				UserService.class);
		applicationContext.registerShutdownHook();
		String name = userService.getUser().getName();

		System.out.println(name);
	}

	// @Test
	public final void testXMLConstructor()
	{
		@SuppressWarnings("resource")
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/constructor_beans.xml");

		ConstructorUserService userService = applicationContext.getBean(
				"constructorUserService", ConstructorUserService.class);
		applicationContext.registerShutdownHook();

		System.out.println(userService);
	}

	@Test
	public final void testAnnotationSetter()
	{
		@SuppressWarnings("resource")
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/annotation_beans.xml");

		AnnotationUserService userService = applicationContext.getBean(
				"annotationUserService", AnnotationUserService.class);
		applicationContext.registerShutdownHook();

		System.out.println(userService);
	}

}
