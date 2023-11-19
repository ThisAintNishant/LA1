import java.util.Scanner;

public class Main {
    // Method to allocate memory to blocks as per Best fit algorithm
    static void bestFit(int blockSize[], int m, int processSize[], int n) {
        // Stores block id of the block allocated to a process
        int allocation[] = new int[n];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {
            // Find the best fit block for the current process
            int bestIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestIdx == -1 || blockSize[bestIdx] > blockSize[j])
                        bestIdx = j;
                }
            }

            // If we could find a block for the current process
            if (bestIdx != -1) {
                // allocate block j to p[i] process
                allocation[i] = bestIdx;
                // Reduce available memory in this block.
                blockSize[bestIdx] -= processSize[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.println(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.println(allocation[i] + 1);
            else
                System.out.println("Not Allocated");
         
        }
    }

    // Driver Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nBest Fit Memory Allocation\n");

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

        bestFit(blockSize, m, processSize, n);
    }
}
