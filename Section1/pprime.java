/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: pprime
*/
// Every palindrome with an even number of digits is divisible by 11, so 11 is the only member of the sequence with an even number of digits


import java.util.*;
import java.io.*;

public class pprime
{
    public static int min;
    public static int max;
    public static PrintWriter out;
    
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner ((new File ("pprime.in")));
        out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        min = scan.nextInt();
        max = scan.nextInt();
        digit1();
        digit2();
        digit3();
        //digit4();
        digit5();
        //digit6();
        digit7();
        out.close();
        System.exit(0);
    }
    public static boolean isPrime (int number)
    {
        if (number % 10 == 5)
            return false;
        for (int i = 2; i < Math.sqrt(number) + 1; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    public static void digit1 ()
    {
        int[] primes = {5, 7};
        for (int i = 0; i < primes.length; i++)
        {
            if (primes[i] >= min && primes[i] <= max)
                /*System.*/out.println(primes[i]);
        }
    }
    public static void digit2 ()
    {
        if (min > 11)
            return;
        if (max < 11)
            return;
        /*System.*/out.println("11");
    }
    public static void digit3 ()
    {
        if (min > 929)
            return;
        if (max < 101)
            return;
        for (int i = 1; i <= 9; i += 2)
        {
            for (int k = 0; k <= 9; k++)
            {
                if (i*100+k*10+i >= min && i*100+k*10+i <= max)
                {
                    if (isPrime(i*100+k*10+i))
                        /*System.*/out.println(i*100+k*10+i);
                }
                else
                    if (i*100+k*10+i > max) 
                        return;
            }
        }
    }
    public static void digit4 ()
    {
        for (int i = 1; i <= 9; i += 2)
        {
            for (int k = 0; k <= 0; k++)
            {
                if (isPrime(i*1000+k*100+k*10+i))
                    /*System.*/out.println(i*1000+k*100+k*10+i);
            }
        }
    }
    public static void digit5 ()
    {
        if (min > 98689)
            return;
        if (max < 10301)
            return;
        for (int i = 1; i <= 9; i++)
        {
            for (int k = 0; k <= 9; k++)
            {
                for (int j = 0; j <= 9; j++)
                {
                    if (i*10000+k*1000+j*100+k*10+i >= min && i*10000+k*1000+j*100+k*10+i <= max)
                    {
                        if (isPrime(i*10000+k*1000+j*100+k*10+i))
                            /*System.*/out.println(i*10000+k*1000+j*100+k*10+i);
                    }
                    else
                        if (i*10000+k*1000+j*100+k*10+i > max)
                            return;
                }
            }
        }
    }
    public static void digit6 ()
    {
        for (int i = 1; i <= 9; i++)
        {
            for (int k = 0; k <= 9; k++)
            {
                for (int j = 0; j <= 9; j++)
                {
                    if (isPrime(i*100000+k*10000+j*1000+j*100+k*10+i))
                        System.out.println(i*100000+k*10000+j*1000+j*100+k*10+i);
                }
            }
        }
    }
    public static void digit7 ()
    {
        if (max < 1003001)
            return;
        for (int i = 1; i <= 9; i += 2)
        {
            for (int k = 0; k <= 9; k++)
            {
                for (int j = 0; j <= 9; j++)
                {
                    for (int a = 0; a <= 9; a++)
                    {
                        if (i*1000000+k*100000+j*10000+a*1000+j*100+k*10+i >= min && i*1000000+k*100000+j*10000+a*1000+j*100+k*10+i <= max)
                        {
                            if (isPrime(i*1000000+k*100000+j*10000+a*1000+j*100+k*10+i))
                                /*System.*/out.println(i*1000000+k*100000+j*10000+a*1000+j*100+k*10+i);
                        }
                        else
                            if (i*1000000+k*100000+j*10000+a*1000+j*100+k*10+i > max)
                                return;
                    }
                }
            }
        }
    }
}
