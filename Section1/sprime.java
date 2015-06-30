/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: sprime
*/

import java.util.*;
import java.io.*;

public class sprime
{
    public static final int[] primes = {2, 3, 5, 7};
    public static final int[] others = {1, 3, 7, 9};
    public static ArrayList<Integer> sprimes = new ArrayList<Integer>();
    
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner ((new File ("sprime.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        int length = scan.nextInt();
        for (int i = 0; i < primes.length; i++)
            search(length, primes[i]);
        for (int i = 0; i < sprimes.size(); i++)
            out.println(sprimes.get(i));
        out.close();
        System.exit(0);
    }
    public static void search (int length, int number)
    {
        if (number > Math.pow(10, length - 1) && number < Math.pow(10, length))
        {
            sprimes.add(number);
            return;
        }
        else
        {
            for (int i = 0; i < others.length; i++)
            {
                if (isPrime(number*10+others[i]))
                    search(length, number*10+others[i]);
            }
        }
    }
    public static boolean isPrime (int number)
    {
        for (int i = 2; i < Math.sqrt(number) + 1; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
