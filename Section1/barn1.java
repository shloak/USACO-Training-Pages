/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: barn1
*/

import java.util.*;
import java.io.*;

public class barn1
{
    public static void main (String ... orange) throws IOException
    {
        Scanner scan = new Scanner (new File ("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        int bars = scan.nextInt();
        int total = scan.nextInt();
        int have = scan.nextInt();
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayList<Integer> locations = new ArrayList<Integer>();
        for (int i = 0; i < have; i++)
        {
            values.add(scan.nextInt());
        }
        Collections.sort(values);
        int first = values.get(0);
        for (int i = 1; i < have; i++)
        {
            int current = values.get(i);
            locations.add(current-first);
            first = current;
        }
        if (bars >= have)
        {
            out.println(have);
        }
        else
        {
            for (int i = 0; i < bars-1; i++)
            {
                locations.remove(Collections.max(locations));
            }
            int sum = 0;
            for (int i = 0; i < locations.size(); i++)
                sum += locations.get(i);
            sum += bars;
            out.println(sum);
        }
        out.close();
        System.exit(0);
    }
}
