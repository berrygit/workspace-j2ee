package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	private static SessionFactory sf = null;

	@BeforeClass
	public static void prepare() {
		try {
			Configuration cfg = new Configuration();
			sf = cfg.configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public final void test() {

		Session session = sf.openSession();

		session.beginTransaction();
		User user = new User();

		user.setName("fda");
		session.save(user);
		session.getTransaction().commit();

	}

	@AfterClass
	public static void clean() {
		sf.close();
	}
}
