/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: combo
*/

import java.util.*;
import java.io.*;

public class combo
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int range = scan.nextInt();
        int[] lock1 = new int[3];
        int[] lock2 = new int[3];
        for (int i = 0; i < 3; i++)
            lock1[i] = scan.nextInt();
        for (int i = 0; i < 3; i++)
            lock2[i] = scan.nextInt();
        int total = 0;
        for (int i = 1; i <= range; i++)
        {
            boolean l11 = false, l12 = false, l13 = false, l21 = false, l22 = false, l23 = false;
            l11 = check (range, 0, lock1, i);
            l21 = check (range, 0, lock2, i);
            if (l11 || l21)
            {
                for (int k = 1; k <= range; k++)
                {
                    l12 = check (range, 1, lock1, k);
                    l22 = check (range, 1, lock2, k);
                    if (l12 || l22)
                    {
                        for (int j = 1; j <= range; j++)
                        {
                            l13 = check (range, 2, lock1, j);
                            l23 = check (range, 2, lock2, j);
                            if (l11 && l12 && l13)
                                total++;
                            else if (l21 && l22 && l23)
                                total++;
                        }
                    }
                }
            }
        }
        out.println(total);
        out.close();
        System.exit(0);
    }
    public static boolean check (int range, int a, int[] lock, int i)
    {
            if (Math.abs(i-lock[a]) < 3)
                return true;
            else if (i == 1 || i == 2)
            {
                if (Math.abs(i+range-lock[a]) < 3)
                    return true;
            }
            else if (i == range || i == range - 1)
            {
                if (Math.abs(range+lock[a]-i) < 3)
                    return true;
            }
            return false;
    }
}
