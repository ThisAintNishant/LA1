import java.util.*;

public class FIFOPageReplacement
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of pages you want to enter");
        int no = sc.nextInt();

        int pageElements[] = new int[no];

        System.out.println("Enter the pages one by one ");

        for (int i = 0; i < no; i++)
        {
            pageElements[i] = sc.nextInt();
        }

        int pageCount = 3;

        List<Integer> pageFrame = new ArrayList<>(pageCount);
        int pageFault = 0;
        int pageHit = 0;

        for (int i = 0; i < no; i++) {
            int page = pageElements[i];

            if (!pageFrame.contains(page))
            {
                pageFault++;
                if (pageFrame.size() >= pageCount)
                {
                    pageFrame.remove(0);
                }
                pageFrame.add(page);
            }
            else
            {
                pageHit++;
            }
        }
        System.out.println("Page Fault = " + pageFault);
        System.out.println("Page Hit = " + pageHit);
    }
}
