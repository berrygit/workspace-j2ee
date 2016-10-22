package behavioral.strategy.interfaces.impl;

import behavioral.strategy.interfaces.FlyBehavior;

public class FlyWithWings implements FlyBehavior
{

	@Override
	public void fly()
	{
		System.out.println("I'm flying!!");
	}

}
