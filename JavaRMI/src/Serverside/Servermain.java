package Serverside;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMIinterface.RMIport;

public class Servermain {
	
	public static void main(String args[]) throws RemoteException, AlreadyBoundException{
		/*if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/
		try{
		server obj = new server();
		Registry registry = LocateRegistry.createRegistry(RMIport.RMI_PORT);
		registry.bind(RMIport.RMI_ID,obj);
		System.out.println("Server is Started");
		}catch(Exception e) {
            System.err.println("Exception:");
            e.printStackTrace();
        }
	}
}
