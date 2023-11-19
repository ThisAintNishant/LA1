// non preemptive algo
import java.util.Scanner;

public class FCFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of processes: ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int burstTime[] = new int[n];
        int arrivalTime[] = new int[n];
        int waitingTime[] = new int[n];
        int turnaroundTime[] = new int[n];
        int completionTime[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the processor id for process " + (i + 1) + ": ");
            pid[i] = sc.nextInt();
            System.out.println("Enter the burst time for process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            System.out.println("Enter the arrival time for process " + (i + 1) + ": ");
            arrivalTime[i] = sc.nextInt();
        }

        // Sorting processes based on arrival time
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrivalTime[j] > arrivalTime[j + 1]) {
                    // Swap the processes
                    int temp = arrivalTime[j];
                    arrivalTime[j] = arrivalTime[j + 1];
                    arrivalTime[j + 1] = temp;

                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;

                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;
                }
            }
        }

        // Calculate waiting time, turnaround time, completion time
        completionTime[0] = burstTime[0];
        turnaroundTime[0] = completionTime[0] - arrivalTime[0];
        waitingTime[0] = turnaroundTime[0] - burstTime[0];

        for (int i = 1; i < n; i++) {
            waitingTime[i] = completionTime[i - 1] - arrivalTime[i];
            completionTime[i] = completionTime[i - 1] + burstTime[i];
            turnaroundTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
        }

        // Display results
        System.out.println("Processor ID\tBurst Time\tArrival Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t\t" + burstTime[i] + "\t\t" + arrivalTime[i] + "\t\t"
                    + completionTime[i] + "\t\t" + turnaroundTime[i] + "\t\t" + waitingTime[i]);
        }
    }
}
