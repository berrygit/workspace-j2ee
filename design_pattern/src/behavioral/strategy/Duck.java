package behavioral.strategy;

import behavioral.strategy.interfaces.FlyBehavior;
import behavioral.strategy.interfaces.QuackBehavior;

public abstract class Duck
{
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public abstract void display();

	public void performQuack()
	{
		quackBehavior.quack();
	}

	public void performFly()
	{
		flyBehavior.fly();
	}

	/**
	 * @param flyBehavior
	 *            the flyBehavior to set
	 */
	public void setFlyBehavior(FlyBehavior flyBehavior)
	{
		this.flyBehavior = flyBehavior;
	}

	/**
	 * @param quackBehavior
	 *            the quackBehavior to set
	 */
	public void setQuackBehavior(QuackBehavior quackBehavior)
	{
		this.quackBehavior = quackBehavior;
	}

	public void swim()
	{
		System.out.println("All ducks float, even decoys!");
	}
}
