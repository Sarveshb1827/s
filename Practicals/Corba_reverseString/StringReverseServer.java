import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import StringReverse.*;

class ReverseImpl extends ReversePOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public void shutdown() {
        orb.shutdown(false);
    }
}

public class StringReverseServer {
    public static void main(String[] args) {
        try {
            // Create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get the reference to the root POA
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("RootPOA");
            POA rootPOA = POAHelper.narrow(objRef);
            
            // Activate the POA manager
            rootPOA.the_POAManager().activate();

            // Create an instance of ReverseImpl and register it with the POA
            ReverseImpl reverseImpl = new ReverseImpl();
            reverseImpl.setORB(orb);
            org.omg.CORBA.Object reverseObj = reverseImpl._this(orb);

            // Obtain a NamingContextExt reference
            objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Bind the Reverse object to the naming context
            NameComponent[] path = ncRef.to_name("Reverse");
            ncRef.rebind(path, reverseObj);

            System.out.println("StringReverse server ready...");

            // Run the ORB event loop
            orb.run();
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.err);
        }
    }
}
