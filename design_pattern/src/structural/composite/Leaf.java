package structural.composite;

import java.util.Iterator;

/**
 * @author berry
 */
public class Leaf extends Component
{
	String name;
	String description;
	boolean vegetarian;
	double price;

	/**
	 * @param name
	 * @param description
	 * @param vegetarian
	 * @param price
	 */
	public Leaf(String name, String description, boolean vegetarian,
			double price)
	{
		super();
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	@Override
	public double getPrice()
	{
		return price;
	}

	@Override
	public boolean isVegetarain()
	{
		return vegetarian;
	}

	@Override
	public void print()
	{
		System.out.println(description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Component> iterator()
	{
		return new NullIterator();
	}

}
