package unit5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MRemote extends Remote {
    int sum(int a, int b) throws RemoteException;
}


