import java.util.Scanner;

class Main {
 
    static void firstFit(int blockSize[], int m, int processSize[], int n) {
    
        int allocation[] = new int[n];
 
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
        
                    allocation[i] = j;

                    blockSize[j] -= processSize[i];
                    break;
                }
            }
        }
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nFirst Fit Memory Allocation\n");

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

        firstFit(blockSize, m, processSize, n);
    }
}
