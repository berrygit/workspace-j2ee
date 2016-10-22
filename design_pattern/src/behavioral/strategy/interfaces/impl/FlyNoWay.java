package behavioral.strategy.interfaces.impl;

import behavioral.strategy.interfaces.FlyBehavior;

public class FlyNoWay implements FlyBehavior
{

	@Override
	public void fly()
	{
		System.out.println("I can't fly.");
	}

}
