/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: transform
*/

import java.util.*;
import java.io.*;

public class transform
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int a = scan.nextInt();
        System.out.println(a);
        char[][] original = new char[a][a];
        char[][] output = new char[a][a];
        String x = scan.nextLine();
        for (int i = 0; i < a; i++)
        {
            String abc = scan.nextLine();
            for (int k = 0; k < abc.length(); k++)
            {
                original[i][k] = abc.charAt(k);
            }
        }
        for (int i = 0; i < a; i++)
        {
            String abc = scan.nextLine();
            for (int k = 0; k < abc.length(); k++)
            {
                output[i][k] = abc.charAt(k);
            }
        }
        if (Arrays.deepEquals(method1(original), output))
            out.println("1");
        else if (Arrays.deepEquals(method2(original), output))
            out.println("2");
        else if (Arrays.deepEquals(method3(original), output))
            out.println("3");
        else if (Arrays.deepEquals(method4(original), output))
            out.println("4");
        else if (Arrays.deepEquals(method1(method4(original)), output) || Arrays.deepEquals(method2(method4(original)), output) ||
                Arrays.deepEquals(method3(method4(original)), output))
            out.println("5");
        else if (Arrays.deepEquals(original, output))
            out.println("6");
        else
            out.println("7");
        out.close();
        System.exit(0);
    }
    public static char[][] method1 (char[][] in)
    {
        char[][] temp = new char[in.length][in[0].length];
        for (int i = 0; i < in.length; i++)
        {
            for (int k = 0; k < in.length; k++)
            {
                temp[k][in.length-1-i] = in[i][k];
            }
        }
        return temp;
    }
    public static char[][] method2 (char[][] in)
    {
        char[][] temp = new char[in.length][in[0].length];
        for (int i = 0; i < in.length; i++)
        {
            for (int k = 0; k < in.length; k++)
            {
                temp[in.length-1-i][in.length-1-k] = in[i][k];
            }
        }
        return temp;
    }
    public static char[][] method3 (char[][] in)
    {
        char[][] temp = new char[in.length][in[0].length];
        for (int i = 0; i < in.length; i++)
        {
            for (int k = 0; k < in.length; k++)
            {
                temp[in.length-1-k][i] = in[i][k];
            }
        }
        return temp;
    }
    public static char[][] method4 (char[][] in)
    {
        char[][] temp = new char[in.length][in.length];
        for (int i = 0; i < in.length; i++)
        {
            for (int k = 0; k < in.length; k++)
                temp[i][in.length-1-k] = in[i][k];
        }
        return temp;
    }
}
