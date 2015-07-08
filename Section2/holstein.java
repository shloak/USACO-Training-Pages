/*package Section2;*/

/*
ID: shloak1
LANG: JAVA
TASK: holstein
*/

import java.util.*;
import java.io.*;

public class holstein
{
    public static ArrayList<Integer> combos = new ArrayList<Integer>();
    public static int[][] values;
    public static int types;
    public static int[] req;
    public static int vits;
    public static boolean done = false;
    public static PrintWriter out;
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader scan = new BufferedReader(new FileReader("holstein.in"));
        //Scanner scan = new Scanner (System.in);
        out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        types = Integer.parseInt(scan.readLine());
        //types = scan.nextInt();
        StringTokenizer st = new StringTokenizer(scan.readLine());
        req = new int[types]; 
        for (int i = 0; i < types; i++)
            req[i] = Integer.parseInt(st.nextToken());
            //req[i] = scan.nextInt();
        vits = Integer.parseInt(scan.readLine());
        //vits = scan.nextInt();
        values = new int[vits][types];
        for (int i = 0; i < vits; i++)
        {
            st = new StringTokenizer(scan.readLine());
            for (int k = 0; k < types; k++)
                values[i][k] = Integer.parseInt(st.nextToken());
                //values[i][k] = scan.nextInt();
        }
        int length = 1;
        while (!done)
        {
            numGen(0, length++);
        }
        out.close();
        System.exit(0);
    }
    public static void numGen (int a, int len)
    {
        if (combos.size() == len)
        {
            check();
            return;
        }
        else
        {
            for (int i = a; i < vits; i++)
            {
                combos.add(i);
                numGen(i+1, len);
                combos.remove(combos.size()-1);
            }
        }
    }
    public static void check ()
    {
        if (done)
            return;
        int[] sums = new int[types];
        for (int i = 0; i < combos.size(); i++)
        {
            for (int k = 0; k < types; k++)
                sums[k] += values[combos.get(i)][k];
        }
        for (int i = 0; i < types; i++)
        {
            if (req[i] > sums[i])
                return;
        }
        out.print(combos.size() + " ");
        for (int i = 0; i < combos.size(); i++)
        {
            if (i < combos.size() - 1)
                out.print((combos.get(i)+1) + " ");
            else
                out.print((combos.get(i)+1) + "\n");
        }
        done = true;
    }
}
