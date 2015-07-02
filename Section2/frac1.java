/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section2;*/

/*
ID: shloak1
LANG: JAVA
TASK: frac1
*/

import java.util.*;
import java.io.*;

public class frac1
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader scan = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        int max = Integer.parseInt(scan.readLine());
        ArrayList<fraction> list = new ArrayList<fraction>();
        list.add(new fraction(0, 1));
        list.add(new fraction(1, 1));
        for (int i = 2; i <= max; i++)
        {
            for (int k = 1; k < i; k++)
            {
                if (!canReduce(k, i))
                    list.add(new fraction(k, i));
            }
        }
        Collections.sort(list, new ValueComparator());
        for (int i = 0; i < list.size(); i++)
        {
            out.println(list.get(i).num + "/" + list.get(i).den);
        }
        out.close();
        System.exit(0);
    }
    public static boolean canReduce (int num, int den)
    {
        for (int i = 2; i <= num; i++)
        {
            if (num % i == 0 && den % i == 0)
                return true;
        }
        return false;
    }
}
class ValueComparator implements Comparator<fraction>
{
    public int compare (fraction a, fraction b)
    {
        /*if (a.value > b.value)
            return 1;
        else if (a.value == b.value)
            return 0;
        return -1;*/
        return a.value < b.value ? -1 : a.value == b.value ? 0 : 1;
    }
}
class fraction
{
    public int num;
    public int den;
    public double value;
    
    public fraction (int nume, int deno)
    {
        num = nume;
        den = deno;
        value = (nume*1.0)/(deno*1.0);
    }
}
