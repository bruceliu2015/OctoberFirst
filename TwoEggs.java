import java.io.*;

public class TwoEggs
{
    public static void main(String[] args)
    {
        Console con = System.console();
        
        System.out.println("Please enter the index of the first element that has a value of 1:");
        String value = con.readLine();
        int n = -1;
        
        try
        {
            n = Integer.parseInt(value);
        }
        catch (NumberFormatException ex)
        {
            System.out.println(value + " is not a number.");
            return;
        }
        
        if (n < 0 || n > 99)
        {
            System.out.println("The number should be in the range of [0, 99]");
            return;
        }
        
        int[] a = new int[100];
        for (int i = n; i < a.length; ++i)
        {
            a[i] = 1;
        }
        
        n = find(a);
        System.out.printf("The index of the first element that has a value of 1 is %d\n", n);
    }
    
    private static int find(int[] a)
    {
        int n = (int) Math.ceil((Math.sqrt(8 * a.length + 1) - 1) / 2);
        int start = 0;
        int end = n - 1;

        System.out.printf("visited %d\n", end);
        
        while (end < a.length && a[end] == 0)
        {
            --n;
            start = end + 1;
            end = end + n;

            if (end < a.length)
            {
                System.out.printf("visited %d\n", end);
            }
        }
        
        int i = start;
        System.out.printf("visited %d\n", i);
        for (; i < a.length && a[i] == 0;)
        {
            ++i;
            System.out.printf("visited %d\n", i);
        }
        
        if (i == a.length)
        {
            return -1;
        }
        
        return i;
    }
}
