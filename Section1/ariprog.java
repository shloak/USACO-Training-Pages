/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: ariprog
*/

import java.util.*;
import java.io.*;

public class ariprog
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (/*System.in*/new File ("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int length = scan.nextInt();
        int max = scan.nextInt();
        int[] squares = new int[(max)*max*2+1];
        //ArrayList<Integer> squares = new ArrayList<Integer>();
        for (int i = 0; i <= max; i++)
        {
            for (int j = i; j <= max; j++)
            {
                squares[i*i+j*j] = 1;
            }
        }
        ArrayList<Integer> starts = new ArrayList<Integer>();
        ArrayList<Integer> diffs = new ArrayList<Integer>();
        boolean has = false;
        for (int diff = 1; diff <= ((max*max*2/(length-1))); diff++)
        {
            for (int start = 0; start < squares.length - length; start++)
            {
                if (squares[start] == 1)
                {
                    if (check(diff, start, squares, length))
                    {
                        starts.add(start);
                        diffs.add(diff);
                        //out.println(squares[start] + " " + diff);
                        has = true;
                    }
                }
            }
        }
        remove(starts, diffs);
        for (int i = 0; i < starts.size(); i++)
        {
            /*System.*/out.println(starts.get(i) + " " + diffs.get(i));
        }
        if (!has)
            /*System.*/out.println("NONE");
        out.close();
        System.exit(0);
    }
    public static void remove (ArrayList<Integer> list, ArrayList<Integer> list2)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            for (int k = i + 1; k < list.size(); k++)
            {
                if (list.get(i).equals(list.get(k)) && list2.get(i).equals(list2.get(k)))
                {
                    list.remove(k);
                    list2.remove(k);
                    k--;
                }
            }
        }
    }
    public static boolean check (int diff, int start, int[] squares, int length)
    {
        for (int i = 1; i < length; i++)
        {
            if (start+diff*i >= squares.length || squares[start+diff*i] != 1)
                return false;
        }
        return true;
        //int target = 1;
        /*int current = squares.get(start);
        for (int i = 1; i < length; i++)
        {
            if (!squares.contains(current + diff*i))
                return false;
        }*/
        /*for (int i = start + 1; i < squares.length; i++)
        {
            if (squares[i] - current == diff)
            {
                target++;
                current = squares[i];
                if (target == length)
                    return true;
            }
        }*/
        //return true;
    }
}
