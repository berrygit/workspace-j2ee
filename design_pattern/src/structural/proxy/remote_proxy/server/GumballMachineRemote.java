package structural.proxy.remote_proxy.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import behavioral.state.interfaces.State;

public interface GumballMachineRemote extends Remote
{
	/**
	 * 2015年6月25日 $ getCount GumballMachineRemote GumballMachineRemote.java
	 * proxy_pattern.remote_proxy.server design_pattern int
	 *
	 * @return
	 * @throws RemoteException
	 *             下午5:13:00 TODO berry 2015
	 * @return int
	 */
	int getCount() throws RemoteException;

	/**
	 * 2015年6月25日 $ getState GumballMachineRemote GumballMachineRemote.java
	 * proxy_pattern.remote_proxy.server design_pattern State
	 *
	 * @return
	 * @throws RemoteException
	 *             下午5:12:56 TODO berry 2015
	 * @return State
	 */
	State getState() throws RemoteException;
}
