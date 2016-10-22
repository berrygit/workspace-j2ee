package structural.proxy.remote_proxy.driver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import structural.proxy.remote_proxy.server.GumballMachineRemote;
import behavioral.state.GumballMachine;

public class GamballMachineTestDrive
{
	public static void main(String[] args) throws RemoteException
	{
		GumballMachineRemote machine = null;

		machine = new GumballMachine();
		try
		{
			Naming.rebind("sea", machine);
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
