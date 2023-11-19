import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the reference string: ");
        int n = scanner.nextInt();

        int[] referenceString = new int[n];
        System.out.println("Enter the elements of the reference string:");

        for (int i = 0; i < n; i++) {
            referenceString[i] = scanner.nextInt();
        }

        System.out.print("Enter the table size: ");
        int tableSize = scanner.nextInt();

        int faults = 0;
        int hits = 0;
        List<Integer> pages = new ArrayList<>();

        for (int page : referenceString) {
            if (pages.contains(page)) {
                pages.remove(Integer.valueOf(page));
                pages.add(page);
                hits++;
            }
            else {
                if (pages.size() < tableSize) {
                    pages.add(page);
                } else {
                    pages.remove(0);
                    pages.add(page);
                }
                faults++;
            }
        }

        System.out.println("Total page faults = " + faults);
        System.out.println("Total page Hits = " + hits);
    }
}
