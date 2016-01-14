package RMIinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface compute extends Remote{
	
	public String executeTask(String item) throws RemoteException;
}
