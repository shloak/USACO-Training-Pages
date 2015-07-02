/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section2;*/

/*
ID: shloak1
LANG: JAVA
TASK: sort3
*/

import java.util.*;
import java.io.*;

public class sort3
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader scan = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int nums = Integer.parseInt(scan.readLine());
        int ones = 0, twos = 0, threes = 0, oneto2 = 0, oneto3 = 0, twoto1 = 0, twoto3 = 0, threeto1 = 0, threeto2 = 0;
        int[] numbers = new int[nums];
        for (int i = 0; i < nums; i++)
        {
            numbers[i] = Integer.parseInt(scan.readLine());
            if (numbers[i] == 1)
                ones++;
            else if (numbers[i] == 2)
                twos++;
            else
                threes++;
        }
        for (int i = 0; i < ones; i++)
        {
            if (numbers[i] == 2)
                oneto2++;
            else if (numbers[i] == 3)
                oneto3++;
        }
        for (int i = ones; i < ones+twos; i++)
        {
            if (numbers[i] == 1)
                twoto1++;
            else if (numbers[i] == 3)
                twoto3++;
        }
        for (int i = ones+twos; i < numbers.length; i++)
        {
            if (numbers[i] == 1)
                threeto1++;
            else if (numbers[i] == 2)
                threeto2++;
        }
        int total = 0;
        
        int a = Math.min(oneto2, twoto1);
        oneto2 -= a;
        twoto1 -= a;
        total += a;
        a = Math.min(oneto3, threeto1);
        oneto3 -= a;
        threeto1 -= a;
        total += a;
        a = Math.min(twoto3, threeto2);
        twoto3 -= a;
        threeto2 -= a;
        total += a;
        if (oneto2 > 0)
        {
            total += 2*oneto2;
        }
        if (oneto3 > 0)
        {
            total += 2*oneto3;
        }
        out.println(total);
        out.close();
        System.exit(0);
    }
    
}
