/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: skidesign
*/

import java.util.*;
import java.io.*;

public class skidesign
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int hills = scan.nextInt();
        int[] elevations = new int[hills];
        for (int i = 0; i < hills; i++)
        {
            elevations[i] = scan.nextInt();
        }
        Arrays.sort(elevations);
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < 84; i++)
        {
            int current = 0;
            for (int k = 0; k < elevations.length; k++)
            {
                if (elevations[k] < i)
                    current += (i-elevations[k])*(i-elevations[k]);
                else if (elevations[k] > (i+17))
                    current += (elevations[k] - (i+17)) * (elevations[k] - (i+17));
            }
            if (current < cost)
                cost = current;
        }
        out.println(cost);
        //System.out.println(Math.min(Math.min(bToT(elevations), tToB(elevations)), half(elevations)));
        out.close();
        System.exit(0);
    }
    /*public static int bToT (int[] elevations)
    {
        int[] temp = Arrays.copyOf(elevations, elevations.length);
        int added = 0;
        for (int i = 0; i < temp.length; i++)
        {
            int current = 0;
            if (temp[temp.length-1]-temp[i] > 17)
            {
                current = temp[temp.length-1] - 17 - temp[i];
                temp[i] += current;
                added += current*current;
                Arrays.sort(temp);
            }
        }
        return added;
    }
    public static int tToB (int[] elevations)
    {
        int[] temp = Arrays.copyOf(elevations, elevations.length);
        int added = 0;
        for (int i = temp.length - 1; i > 0; i--)
        {
            int current = 0;
            if (temp[i] - temp[0] > 17)
            {
                current = temp[i] - (temp[0] + 17);
                temp[i] -= current;
                added += current*current;
                Arrays.sort(temp);
            }
        }
        return added;
    }
    public static int half (int[] elevations)
    {
        int[] temp = Arrays.copyOf(elevations, elevations.length);
        int added = 0;
        int it = 0;
        while (it < temp.length)
        {
            int current = 0;
            if (temp[temp.length-1] - temp[it] > 17)
            {
                current = temp[temp.length-1] - 17 - temp[it];
                temp[it] += current/2;
                added += (current/2)*(current/2);
                temp[temp.length-1] -= current - current/2;
                added += (current - current/2)*(current - current/2);
                Arrays.sort(temp);
            }
            else
                it++;
        }
        System.out.println(Arrays.toString(temp));
        return added;
    }*/
}
