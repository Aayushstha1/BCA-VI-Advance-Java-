package unit5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MClient {
    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.getRegistry("localhost", 1099);
            MRemote mro = (MRemote) r.lookup("abc");
          System.out.println(" sum is: " + mro.sum(5, 10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
