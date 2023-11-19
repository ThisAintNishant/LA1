import java.util.*;

public class SJF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        int pid[] = new int[n]; // it takes pid of the process
        int at[] = new int[n]; // at means arrival time
        int bt[] = new int[n]; // bt means burst time
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n];// ta means turn around time
        int wt[] = new int[n]; // wt means waiting time
        int f[] = new int[n]; // f means it is flag it checks process is completed or not
        int k[] = new int[n]; // it also stores burst time
        int i, st = 0, tot = 0;
        float avgwt = 0, avgta = 0;

        for (i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time: ");
            bt[i] = sc.nextInt();
            k[i] = bt[i];
            f[i] = 0;
        }

        while (true) {
            int min = 99, c = n;
            if (tot == n)
                break;

            for (i = 0; i < n; i++) {
                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }

            if (c == n)
                st++;
            else {
                bt[c]--;
                st++;
                if (bt[c] == 0) {
                    ct[c] = st;
                    f[c] = 1;
                    tot++;
                }
            }
        }

        for (i = 0; i < n; i++) {
            ta[i] = ct[i] - at[i];
            wt[i] = ta[i] - k[i];
            avgwt += wt[i];
            avgta += ta[i];
        }

        System.out.println("\n ------ SJF ------ \n");
        System.out.println("==========================================================================================");
        System.out.println("\nProcess\t\tArrivalT\tBurstT\t\tCompleteT\tTurnT\t\tWaitingT");
        System.out.println("==========================================================================================");
        
        for (i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t\t" + at[i] + "\t\t" + k[i] + "\t\t" + ct[i] + "\t\t" + ta[i] + "\t\t" + wt[i]);
        }

        System.out.println("\nAverage waiting time: " + (avgwt / n));
        System.out.println("Average turnaround time: " + (avgta / n));

        sc.close();
    }
}
