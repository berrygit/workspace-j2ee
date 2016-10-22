/**
 *
 */
package behavioral.state;

import behavioral.state.interfaces.State;

/**
 * @author berry
 */
public class HasQuarterState implements State
{
	private static final long serialVersionUID = -1900042907914089264L;

	transient GumballMachine gamballMachine;

	public HasQuarterState(GumballMachine gamballMachine)
	{
		this.gamballMachine = gamballMachine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state_pattern.interfaces.State#insertQuarter()
	 */
	@Override
	public void insertQuarter()
	{
		System.out.println("you can't insert another quarter");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state_pattern.interfaces.State#ejectQuarter()
	 */
	@Override
	public void ejectQuarter()
	{
		System.out.println("quarter returned");
		gamballMachine.setState(gamballMachine.getNoQuarterState());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state_pattern.interfaces.State#turnCrank()
	 */
	@Override
	public void turnCrank()
	{
		System.out.println("you turned...");
		gamballMachine.setState(gamballMachine.getSoldState());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state_pattern.interfaces.State#dispense()
	 */
	@Override
	public void dispense()
	{
		System.out.println("no gamball dispense");
	}

}
