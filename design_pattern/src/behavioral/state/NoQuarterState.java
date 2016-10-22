package behavioral.state;

import behavioral.state.interfaces.State;

public class NoQuarterState implements State
{
	private static final long serialVersionUID = -5900799655555640857L;

	transient GumballMachine gamballMachine;

	public NoQuarterState(GumballMachine gamballMachine)
	{
		super();
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
		System.out.println("you inserted a quarter");
		gamballMachine.setState(gamballMachine.getHasQuarterState());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state_pattern.interfaces.State#ejectQuarter()
	 */
	@Override
	public void ejectQuarter()
	{
		// TODO Auto-generated method stub
		System.out.println("you haven't inserted a quarter");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state_pattern.interfaces.State#tumCrank()
	 */
	@Override
	public void turnCrank()
	{
		System.out.println("you turned, but there's no quarter");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state_pattern.interfaces.State#dispense()
	 */
	@Override
	public void dispense()
	{
		System.out.println("you need to pay first");
	}

}
