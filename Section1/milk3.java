/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: milk3
*/

import java.util.*;
import java.io.*;

public class milk3
{
    public static int[][] searched = new int[21][21];
    public static int[] zs = new int[21];
    
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner ((new File ("milk3.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        int[] caps = new int[3];
        for (int i = 0; i < 2; i++)
            caps[i] = scan.nextInt();
        int c = scan.nextInt();
        caps[2] = c;
        search(0, 0, c, caps);
        boolean first = true;
        for (int i = 0; i < zs.length; i++)
        {
            if (zs[i] == 1)
            {
                if (first)
                {
                    out.print(i);
                    first = false;
                }
                else
                    out.print(" " + i);
            }
        }
        out.println();
        out.close();
        System.exit(0);
    }
    public static void search (int a, int b, int c, int[] caps)
    {
        if (searched[a][b] == 1)
            return;
        searched[a][b] = 1;
        if (a == 0)
            zs[c] = 1;
        // a to b
        if (a > 0 && b < caps[1])
        {
            search(a - Math.min(a, caps[1]-b), b + Math.min(a, caps[1]-b), c, caps);
        }
        // a to c
        if (a > 0 && c < caps[2])
        {
            search(a - Math.min(a, caps[2] - c), b, c + Math.min(a, caps[2]-c), caps);
        }
        // b to a
        if (b > 0 && a < caps[0])
        {
            search(a + Math.min(b, caps[0] - a), b - Math.min(b, caps[0] - a), c, caps);
        }
        // b tp c
        if (b > 0 && c < caps[2])
        {
            search(a, b - Math.min(b, caps[2] - c), c + Math.min(b, caps[2] - c) , caps);
        }
        // c to a
        if (c > 0 && a < caps[0])
        {
            search(a + Math.min(c, caps[0] - a), b, c - Math.min(c, caps[0] - a), caps);
        }
        // c to b
        if (c > 0 && b < caps[1])
        {
            search(a, b + Math.min(c, caps[1] - b), c - Math.min(c, caps[1] - b), caps);
        }
    }
}
