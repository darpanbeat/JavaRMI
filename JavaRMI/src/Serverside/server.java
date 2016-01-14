package Serverside;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import RMIinterface.compute;


public class server extends UnicastRemoteObject implements compute{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public server() throws RemoteException{
		super();
	}

	
	public String executeTask(String item) throws RemoteException {
		
		String nothing = null;
		
		if(item.endsWith("location1")){
			String result = item.substring(0,item.length()-9);
			nothing = FindLocation.artistlocation_id(result);
			//System.out.println("server :"+nothing);	
		}else{
			String text = item.substring(0,item.length()-5);
			nothing = GetSongs.songs_id(text);
			//System.out.println("server :"+nothing);
			} 
		
		return nothing;
	}
	
}
