/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: wormhole
*/

import java.util.*;
import java.io.*;

public class wormhole 
{
    //public static final int[] sizes = {0, 0, 1, 0, 3, 0, 15, 0, 105, 0, 954, 0, 10395};
    
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        int number = scan.nextInt();
        int[] X = new int[number+1];
        int[] Y = new int[number+1];
        for (int i = 1; i < number+1; i++)
        {
            X[i] = scan.nextInt();
            Y[i] = scan.nextInt();
        }
        int[] combos = new int[number+1];
        out.println(solve(number, X, Y, combos));
        out.close();
        System.exit(0);
        /*int[][] all = new int[number][2];
        for (int i = 0; i < number; i++)
        {
            all[i][0] = scan.nextInt();
            all[i][1] = scan.nextInt();
        }
        wormholes[] allW = new wormholes[number];
        for (int i = 0; i < number; i++)
            allW[i] = new wormholes(all[i][0], all[i][1]);
        wormholes[] next = new wormholes[number];
        for (int i = 0; i < number; i++)
            next[i] = allW[i].getNext(allW);
        int counter = 0;
        wormholes[][] combinations = new wormholes[sizes[number]][number];
        for (int i = 1; i < number; i++)
        {
            combinations[counter][0] = allW[0];
            combinations[counter][1] = allW[i];
            if (number > 2)
            {
                for (int k = 1; k < number; k++)
                {
                    if (k != i)
                    {
                        combinations[counter][2] = allW[k];
                    }
                    for (int a = 1; a < number; a++)
                    {
                        if (a != i && a != k)
                        {
                            combinations[counter][3] = allW[a];
                        }
                        if (number > 4)
                        {
                            
                        }
                    }
                }
            }
            counter++;
        }
        int total = 0;
        for (int i = 0; i < combinations.length; i++)
        {
            for (int k = 0; k < combinations[i].length; k++)
            {
                ArrayList<wormholes> wList = new ArrayList<wormholes>();
                wormholes current = combinations[i][k];
                wList.add(current);
                while (current.getNext(allW) != null)
                {
                    if (find(current.getNext(allW), combinations[i]) % 2 == 0)
                    {
                        current = combinations[i][find(current.getNext(allW), combinations[i]) + 1];
                    }
                    else
                    {
                        current = combinations[i][find(current.getNext(allW), combinations[i]) - 1];
                    }
                    wList.add(current);
                    if (listCheck(wList))
                    {
                        total++;
                        break;
                    }
                }
            }
        }*/
    }
    public static int getRight (int a, int number, int[] X, int[] Y)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < number+1; i++)
        {
            if (X[a] < X[i] && Y[a] == Y[i])
            {
                list.add(i);
            }
        }
        int min;
        if (list.size() == 0)
            return -1;
        else
        {
            min = 0;
            for (int i = 1; i < list.size(); i++)
            {
                if (X[list.get(i)] < X[list.get(min)])
                    min = i;
            }
        }
        return list.get(min);
    }
    public static boolean isCycle (int number, int[] X, int[] Y, int[] combos)
    {
        for (int i = 1; i < number+1; i++)
        {
            int k;
            int current = i;
            for (k = 0; k < number; k++)
            {
                if (getRight(combos[current], number, X, Y) == -1)
                    break;
                else
                {
                    current = getRight(combos[current], number, X, Y);
                }
            }
            if (k >= number)
                return true;
        }
        return false;
    }
    public static int solve (int number, int[] X, int[] Y, int[] combos)
    {
        int total = 0;
        int i;
        for (i = 1; i < number+1; i++)
        {
            if (combos[i] == 0)
            {
                break;
            }
        }
        if (i >= number)
        {
            if (isCycle(number, X, Y, combos))
                return 1;
            return 0;
        }
        for (int j = i+1; j < number+1; j++)
        {
            if (combos[j] == 0)
            {
                combos[i] = j;
                combos[j] = i;
                total += solve(number, X, Y, combos);
                combos[i] = 0;
                combos[j] = 0;
            }
        }
        return total;
    }
    /*public static int find (wormholes a, wormholes[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i].x == a.x && array[i].y == a.y)
                return i;
        }
        return 0;
    }
    public static boolean listCheck (ArrayList<wormholes> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            wormholes current = list.get(i);
            for (int k = i+1; k < list.size(); k++)
            {
                if (list.get(k).x == current.x && list.get(k).y == current.y)
                    return true;
            }
        }
        return false;
    }*/
}
/*class wormholes
{
    public int x;
    public int y;
    public wormholes (int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public wormholes getNext (wormholes[] all) // gets the next wormholes to the right (returns the wormholes or null if none)
    {
        ArrayList<wormholes> list = new ArrayList<wormholes>();
        for (int i = 0; i < all.length; i++)
        {
            if (all[i].y == this.y)
            {
                if (all[i].x != this.x)
                    list.add(all[i]);
            }
        }
        if (list.size() == 0)
            return null;
        else
        {
            wormholes min;
            do
            {
                min = list.get((int)(list.size()*Math.random()));
            }
            while (min.x < this.x);
            for (int i = 0; i < list.size(); i++)
            {
                if (all[i].x > this.x && all[i].x < min.x)
                    min = all[i];
            }
            return min;
        }
    }
}*/