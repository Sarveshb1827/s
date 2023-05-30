import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import StringConcat.Concatenator;
import StringConcat.ConcatenatorHelper;
import java.util.Scanner;

public class ConcatenatorClient {
    public static void main(String[] args) {
        try {
            // Create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // Obtain a NamingContextExt reference
            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));

            // Resolve the object reference from the naming context
            Concatenator concatenator = ConcatenatorHelper.narrow(ncRef.resolve_str("Concatenator"));

            // Prompt the user to enter strings
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter first string: ");
            String s1 = scanner.nextLine();
            System.out.print("Enter second string: ");
            String s2 = scanner.nextLine();
            scanner.close();

            // Perform the concatenation
            String result = concatenator.concatenate(s1, s2);
            System.out.println("Concatenation result: " + result);

            // Shutdown the ORB
            orb.shutdown(true);
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.err);
        }
    }
}
