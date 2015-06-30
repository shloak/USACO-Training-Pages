/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: palsquare
*/

import java.util.*;
import java.io.*;

public class palsquare
{
    static char[] items = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        long base = scan.nextInt();
        for (long i = 1; i <= 300; i++)
        {
            long current = i*i;
            if (isPalindrome(convert(base, current)))
                out.println(convert(base, i) + " " + convert(base, current));
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
            result += items[(int)current];
            num -= value*current;
            value /= base;
        }
        result += items[(int)num];
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
