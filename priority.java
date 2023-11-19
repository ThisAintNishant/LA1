import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int burstTime[] = new int[n];
        int arrivalTime[] = new int[n];
        int priority[] = new int[n];
        int waitingTime[] = new int[n];
        int turnaroundTime[] = new int[n];
        int completionTime[] = new int[n];

        // Input: Process details
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.println("Enter arrival time for process " + pid[i] + ": ");
            arrivalTime[i] = sc.nextInt();
            System.out.println("Enter burst time for process " + pid[i] + ": ");
            burstTime[i] = sc.nextInt();
            System.out.println("Enter priority for process " + pid[i] + ": ");
            priority[i] = sc.nextInt();
        }

        // Sort processes based on priority
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (priority[j] > priority[j + 1]) {
                    // Swap the processes
                    swap(pid, j, j + 1);
                    swap(arrivalTime, j, j + 1);
                    swap(burstTime, j, j + 1);
                    swap(priority, j, j + 1);
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
        System.out.println("Process ID\tArrival Time\tBurst Time\tPriority\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" + priority[i] + "\t\t"
                    + completionTime[i] + "\t\t" + turnaroundTime[i] + "\t\t" + waitingTime[i]);
        }

        sc.close();
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
