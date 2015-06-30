/*
ID: shloak1
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;

class gift1 
{
    public static void main (String ... orange) throws IOException
    {
        Scanner scan = new Scanner (new File ("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        String[] names = new String[scan.nextInt()];
        String x = scan.nextLine();
        for (int i = 0; i < names.length; i++)
        {
            names[i] = scan.nextLine();
        }
        int[] money = new int[names.length];
        for (int i = 0; i < names.length; i++)
        {
            String current = scan.nextLine();
            int index = find(current, names);
            int giving = scan.nextInt();   
            int people = scan.nextInt();
            int spend = 0;
            if (people != 0)
            {
                spend = giving / people;
                money[index] -= (spend*people);
            }
            String y = scan.nextLine();
            for (int k = 0; k < people; k++)
            {
                String s = scan.nextLine();
                money[find(s, names)] += spend;
            }
        }
        for (int z = 0; z < names.length; z++)
        {
            out.println(names[z] + " " + money[z]);
        }
        out.close();
        System.exit(0);
    }
    public static int find (String s, String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i].equals(s))
                return i;
        }
        return 0;
    }
}
