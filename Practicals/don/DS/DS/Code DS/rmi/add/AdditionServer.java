import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionServer {
    public static void main(String args[]) {
        try {
            // Create an instance of the implementation class
            AdditionImpl obj = new AdditionImpl();

            // Bind the remote object in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Addition", obj);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
