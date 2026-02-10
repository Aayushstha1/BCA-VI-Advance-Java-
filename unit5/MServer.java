package unit5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MServer {
    public static void main(String[] args) {
        try {
            MRemoteObject mro = new MRemoteObject();
           Registry r = LocateRegistry.createRegistry(1099);
           r.bind("abc", mro);
           System.out.println("Server is ready");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


