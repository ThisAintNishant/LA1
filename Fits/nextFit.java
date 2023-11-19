import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // Function to allocate memory to blocks as per Next fit algorithm
    static void NextFit(int blockSize[], int m, int processSize[], int n) {
        // Stores block id of the block allocated to a process
        int allocation[] = new int[n];
        int j = 0;

        // Initially no block is assigned to any process
        Arrays.fill(allocation, -1);

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {
            // Do not start from the beginning
            int count = 0;

            while (j < m) {
                count++;
                // makes sure that for every process we traverse through entire array
                // maximum once only. This avoids the problem of going into an infinite loop
                // if memory is not available

                if (blockSize[j] >= processSize[i]) {
                    // allocate block j to p[i] process
                    allocation[i] = j;
                    // Reduce available memory in this block.
                    blockSize[j] -= processSize[i];
                    break;
                }

                // mod m will help in traversing the blocks from
                // starting block after we reach the end.
                j = (j + 1) % m;
            }
        }

        System.out.print("\nProcess No.\tProcess Size\tBlock no.\n");
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.print(allocation[i] + 1);
            } else {
                System.out.print("Not Allocated");
            }
            System.out.println("");
        }
    }

    // Driver program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nNext Fit Memory Allocation\n");

        System.out.print("Enter the number of blocks: ");
        int m = scanner.nextInt();

        int blockSize[] = new int[m];

        System.out.println("Enter the size of each block:");

        for (int i = 0; i < m; i++) {
            blockSize[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int processSize[] = new int[n];

        System.out.println("Enter the size of each process:");

        for (int i = 0; i < n; i++) {
            processSize[i] = scanner.nextInt();
        }

        NextFit(blockSize, m, processSize, n);
    }
}
