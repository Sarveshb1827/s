import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClient {
    public static void main(String[] args) {
        try {
            // Get a reference to the remote object
            Registry registry = LocateRegistry.getRegistry("localhost");
            AdditionInterface obj = (AdditionInterface) registry.lookup("Addition");

            // Call the remote method
            int result = obj.add(4, 5);
            System.out.println("4 + 5 = " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
