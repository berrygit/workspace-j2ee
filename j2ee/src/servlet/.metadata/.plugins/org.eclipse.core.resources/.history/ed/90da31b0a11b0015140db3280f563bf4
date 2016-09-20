package composite_pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite extends Component
{
	List<Component> components = new ArrayList<Component>();
	String name;
	String description;

	public Composite(String name, String description)
	{
		super();
		this.name = name;
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see composite_pattern.Component#add(composite_pattern.Component)
	 */
	@Override
	public void add(Component component)
	{
		components.add(component);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see composite_pattern.Component#remove(composite_pattern.Component)
	 */
	@Override
	public void remove(Component component)
	{
		components.remove(component);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see composite_pattern.Component#getChild(int)
	 */
	@Override
	public Component getChild(int i)
	{
		return components.get(i);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see composite_pattern.Component#getName()
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see composite_pattern.Component#getDescription()
	 */
	@Override
	public String getDescription()
	{
		return description;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see composite_pattern.Component#print()
	 */
	@Override
	public void print()
	{
		System.out.println(description);
		Iterator<Component> iterator = components.iterator();
		while (iterator.hasNext())
		{
			Component component = iterator.next();
			component.print();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Component> iterator()
	{
		return new CompositeIterator(components.iterator());
	}
}
