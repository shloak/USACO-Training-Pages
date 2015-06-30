/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: milk
*/

import java.util.*;
import java.io.*;

public class milk
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        long needed = scan.nextLong();
        int farmers = scan.nextInt();
        long sum = 0;
        long added = 0;
        long[] prices = new long[farmers];
        long[] available = new long[farmers];
        for (int i = 0; i < farmers; i++)
        {
            prices[i] = scan.nextLong();
            available[i] = scan.nextLong();
        }
        while (needed > 0)
        {
            int smallest = getSmallest(prices, available);
            added = Math.min(available[smallest], needed);
            sum += added*prices[smallest];
            needed -= added;
            available[smallest] -= added;
        }
        out.println(sum);
        out.close();
        System.exit(0);
    }
    public static int getSmallest (long[] prices, long[] available)
    {
        int min;
        do
            min = (int)(Math.random()*(prices.length));
        while (available[min] == 0);
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < prices[min] && available[i] > 0)
                min = i;
        }
        return min;
    }
}
