import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class Client {
    private Client() {}

    public static void main(String[] args) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            ServerInterface stub = (ServerInterface) registry.lookup("ServerInterface");

            // Calling the remote method using the obtained object
            String message = stub.getMessage();

            System.out.println("Remote method returned: " + message);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
