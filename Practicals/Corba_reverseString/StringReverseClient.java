import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import StringReverse.*;
import java.util.Scanner;

public class StringReverseClient {
    public static void main(String[] args) {
        try {
            // Create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // Obtain a NamingContextExt reference
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the Reverse object reference from the naming context
            Reverse reverseObj = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));

            // Prompt the user to enter a string
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            scanner.close();

            // Invoke the reverseString operation
		int start=0;
		int end=input.length-1;
while(start<end){

}
            String reversed = reverseObj.reverseString(input);
            System.out.println("Reversed string: " + reversed);

            // Shutdown the ORB
            orb.shutdown(true);
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.err);
        }
    }
}
