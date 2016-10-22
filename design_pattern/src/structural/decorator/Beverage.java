package structural.decorator;

public abstract class Beverage
{
	protected String description = "unkown";

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	public abstract double cost();
}
