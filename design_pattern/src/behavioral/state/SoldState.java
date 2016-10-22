package behavioral.state;

import behavioral.state.interfaces.State;

public class SoldState implements State
{

	private static final long serialVersionUID = -6657300847946757679L;

	transient GumballMachine gamballMachine;

	public SoldState(GumballMachine gamballMachine)
	{
		this.gamballMachine = gamballMachine;
	}

	@Override
	public void insertQuarter()
	{
		System.out.println("Please wait");
	}

	@Override
	public void ejectQuarter()
	{
		System.out.println("you already turned");
	}

	@Override
	public void turnCrank()
	{
		System.out.println("you turn twice");
	}

	@Override
	public void dispense()
	{
		gamballMachine.releaseBall();
		if (gamballMachine.getCount() > 0)
		{
			gamballMachine.setState(gamballMachine.getNoQuarterState());
		}
		else
		{
			System.out.println("Oops");
			gamballMachine.setState(gamballMachine.getSoldOutState());
		}
	}
}
