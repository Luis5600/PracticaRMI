package server;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.EchoInt;

public class EchoObjectRMI implements EchoInt {

	public static void main(String[] args) {

	       try {
	            EchoInt stub = (EchoInt) UnicastRemoteObject.exportObject(new EchoObjectRMI(),0);
	            Registry registry = LocateRegistry.createRegistry(1888);
	            registry.rebind("echo", stub);
	        } catch (RemoteException e) {
	            System.err.println("Something wrong happended on the remote end");
	            e.printStackTrace();
	            System.exit(-1); // can't just return, rmi threads may not exit
	        }
	        System.out.println("The echo server is ready");

	}

        
    public EchoObjectRMI()  { //throws RemoteException
        super();
    }
    private static EchoObject eo = new EchoObject();
    
    @Override
    public String echo(String input) {
        return eo.echo(input);
    }
}