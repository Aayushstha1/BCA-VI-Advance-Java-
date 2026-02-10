package unit5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MRemoteObject extends UnicastRemoteObject implements MRemote {
     MRemoteObject() throws RemoteException {
        super();
    }
    @Override
    public int sum(int a, int b ) throws RemoteException {
        return (a+b);
    }
}
