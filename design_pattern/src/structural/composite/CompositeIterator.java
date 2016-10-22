package structural.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<Component>
{
	Stack<Iterator<Component>> stack = new Stack<Iterator<Component>>();

	public CompositeIterator(Iterator<Component> iterator)
	{
		super();
		this.stack.push(iterator);
	}

	@Override
	public Component next()
	{
		if (hasNext())
		{
			Iterator<Component> iterator = stack.peek();
			Component component = iterator.next();
			if (component instanceof Composite)
			{
				stack.push(component.iterator());
				return next();
			}
			else
			{
				return component;
			}

		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean hasNext()
	{
		if (stack.empty())
		{
			return false;
		}
		else
		{
			Iterator<Component> inIterator = stack.peek();
			if (!inIterator.hasNext())
			{
				stack.pop();
				return hasNext();
			}
			else
			{
				return true;
			}
		}
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}
