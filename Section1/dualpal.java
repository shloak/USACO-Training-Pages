/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: dualpal
*/

import java.util.*;
import java.io.*;

public class dualpal
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        long number = scan.nextInt();
        long min = scan.nextInt();
        int count = 0;
        for (long i = min + 1; ; i++)
        {
            int count2 = 0;
            for (long k = 2; k <= 10; k++)
            {
                if (count2 == 2)
                    break;
                if (isPalindrome(convert(k, i)))
                    count2++;
            }
            if (count2 == 2)
            {
                count++;
                out.println(i);
            }
            if (count == number)
                break;
        }
        out.close();
        System.exit(0);
    }
        public static String convert (long base, long num)
    {
        long value = 1;
        String result = "";
        while (num >= value*base)
            value *= base;
        while (value > 1)
        {
            long current = num/value;
            result += current;
            num -= value*current;
            value /= base;
        }
        result += num;
        return result;
    }
    public static boolean isPalindrome (String str)
    {
        for (int i = 0; i < str.length()/2; i++)
        {
            if (str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }
        return true;
    }
}
