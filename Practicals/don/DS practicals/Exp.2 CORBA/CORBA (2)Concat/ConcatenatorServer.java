import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class ConcatenatorServer {
    public static void main(String[] args) {
        try {
            // Create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get reference to Root POA and activate the POAManager
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            // Create an instance of ConcatenatorImpl
            ConcatenatorImpl concatenatorImpl = new ConcatenatorImpl();

            // Activate the servant with the Root POA
            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(concatenatorImpl);

            // Obtain a NamingContextExt reference
            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));

            // Create a NameComponent array to hold the object's name
            NameComponent[] nc = ncRef.to_name("Concatenator");

            // Bind the object reference in the naming context
            ncRef.rebind(nc, ref);

            System.out.println("ConcatenatorServer ready...");

            // Wait for incoming requests
            orb.run();
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.err);
        }
    }
}
