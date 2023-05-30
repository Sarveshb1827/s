import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CircleServer {
    public static void main(String[] args) {
        try {
            Circle circle = new Circle();
            //LocateRegistry.createRegistry(9999); // Start the RMI registry on port 9999
           Naming.rebind("Circle", circle); // Bind the remote object to the name "Circle"
           System.out.println("Server started");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

