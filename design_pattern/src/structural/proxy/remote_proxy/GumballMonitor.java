package structural.proxy.remote_proxy;

import behavioral.state.GumballMachine;

public class GumballMonitor
{
	/**
	 * gamballMachine
	 */
	private GumballMachine gamballMachine;

	/**
	 * @param gamballMachine
	 */
	public GumballMonitor(GumballMachine gamballMachine)
	{
		this.gamballMachine = gamballMachine;
	}

	/**
	 * report
	 */
	public void report()
	{
		System.out.println("State" + gamballMachine.getState());
	}
}
