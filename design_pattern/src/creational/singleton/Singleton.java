package creational.singleton;

public class Singleton
{
	private static Singleton instance = null;

	/**
	 * Singleton constructor
	 */
	protected Singleton()
	{
	}

	public static Singleton getInstance()
	{
		// lazy initial
		if (null == instance)
		{
			instance = new Singleton();
		}

		return instance;
	}
}
