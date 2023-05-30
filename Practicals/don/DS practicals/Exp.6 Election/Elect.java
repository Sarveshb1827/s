import java.util.Scanner;

public class Elect {

    class Pro {
        int id;
        boolean act;
        Pro(int id) {
            this.id = id;
            act = true;
        }
    }
    
    int TotalProcess;
    Pro[] process;
    
    public Elect() { }
    
    public void initialiseGFG(int n) {
        System.out.println("No of processes " + n);
        int k=0;
        while(k < n) {
            System.out.print(" "+ k +" -> ");
            k++;
        }
        
        TotalProcess = n;
        process = new Pro[TotalProcess];
        int i = 0;
        while (i < process.length) {
            process[i] = new Pro(i);
            i++;
        }
    }
    
    public void Election() {
        System.out.println("\n");
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Number of Failed Processes:");
        int process_failed = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        for (int i = 0; i < arr.length; i++) {
            if (process_failed + 1 == arr[i]) {
                // shifting elements
                for (int j = i; j < process.length - 1; j++) {
                    process[j] = process[j+1];
                }
                break;
            }
        }
        
        System.out.println("Election Initiated by 2");
        int initializedProcess = 2;
        int old = initializedProcess;
        int newer = old + 1;
        int[] data = new int[20];
        int inc = 0;
        
        while (true) {
            if (process[newer].act) {
                System.out.println("Process " + process[old].id +
                                   " pass Election Process(" + process[old].id +
                                   ") to " + process[newer].id + " [" + old + "," + newer + "]");
				//System.out.print(" ["+ process[old].id + ",] ");
                old = newer;
            }
            data[inc] = old;
            newer = (newer + 1) % TotalProcess;
            if (newer == initializedProcess) {
                break;
            }
            inc++;
        }
        
        System.out.println("Process " + process[FetchMaximum()].id + " becomes coordinator");
        int coord = process[FetchMaximum()].id;
        old = coord;
        newer = (old + 1) % TotalProcess;
        
        while (true) {
            if (process[newer].act) {
                System.out.println("Process " + process[old].id +
                                   " pass Coordinator(" + coord +
                                   ") message to process " + process[newer].id);
                old = newer;
            }
            newer = (newer + 1) % TotalProcess;
            if (newer == coord) {
                System.out.println("End Of Election");
                break;
            }
        }
    }
    
    public int FetchMaximum() {
        int Ind = 0;
        int maxId = -9999;
        int i = 0;
        while (i < process.length) {
            if (process[i].act && process[i].id > maxId) {
                maxId = process[i].id;
                Ind = i;
            }
            i++;
        }
        return Ind;
    }
    

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        Elect object = new Elect();
        object.initialiseGFG(n);
        object.Election();
    }
}
