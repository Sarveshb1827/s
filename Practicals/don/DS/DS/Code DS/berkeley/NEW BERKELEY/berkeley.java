import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class berkeley {
    public static void berkeleyAlgo(String servertime, String time1, String time2) {
        System.out.println("Server Clock   = " + servertime);
        System.out.println("Client Clock 1 = " + time1);
        System.out.println("Client Clock 2 = " + time2);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
        try {
            /* Converting time to Milliseconds */
            long s = sdf.parse(servertime).getTime();
            long t1 = sdf.parse(time1).getTime();
            long t2 = sdf.parse(time2).getTime();
            /* Calculating time differences w.r.t server */
            long st1 = t1 - s;
            System.out.println("t1 - s = " + st1/1000);
            long st2 = t2 - s;
            System.out.println("t2 - s = " + st2/1000);
            /* Fault tolerant Average */
            long aveg = (st1 + st2 + 0) / 3;
            System.out.println("(st1 + st2 + 0)/3 = " + aveg/1000);
            /* Adjustment */
            long adjserver = aveg + s;
            long adj_t1 = aveg - st1;
            long adj_t2 = aveg - st2;
            System.out.println("t1 adjustment = " + adj_t1/1000);
            System.out.println("t2 adjustment = " + adj_t2/1000);
            /* Sync clock */
            System.out.println("Synchronized Server Clock  = " + sdf.format(new Date(adjserver)));
            System.out.println("Synchronized Client1 Clock = " + sdf.format(new Date(t1 + adj_t1)));
            System.out.println("Synchronized Client2 Clock = " + sdf.format(new Date(t2 + adj_t2)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the server time (HH:MM): ");
        String serverTime = scanner.nextLine();
        System.out.print("Enter the client1 time (HH:MM): ");
        String time1 = scanner.nextLine();
        System.out.print("Enter the client2 time (HH:MM): ");
        String time2 = scanner.nextLine();
        scanner.close();
        
        berkeleyAlgo(serverTime, time1, time2);
    }
}
