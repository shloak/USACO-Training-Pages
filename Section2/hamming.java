
/*package Section2;*/

/*
ID: shloak1
LANG: JAVA
TASK: hamming
*/

import java.util.*;
import java.io.*;

public class hamming
{
    public static PrintWriter out;
    public static int num;
    public static int len;
    public static int dist;
    public static ArrayList<Integer> listInt = new ArrayList<Integer>();
    public static ArrayList<String> listString = new ArrayList<String>();
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader scan = new BufferedReader(new FileReader("hamming.in"));
        //Scanner scan = new Scanner (System.in);
        out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(scan.readLine());
        num = Integer.parseInt(st.nextToken());
        //num = scan.nextInt();
        len = Integer.parseInt(st.nextToken());
        //len = scan.nextInt();
        dist = Integer.parseInt(st.nextToken());
        //dist = scan.nextInt();
        listInt.add(new Integer(0));
        listString.add(genNum(0));
        for (int i = 1; i < Math.pow(2, len); i++)
        {
            if (listInt.size() < num)
            {
                if (check(genNum(i)))
                    listInt.add(i);
            }
        }
        for (int i = 0; i < num; i++)
        {
            if (i%10 == 9)
                out.print(listInt.get(i) + "\n");
            else if (i == num - 1)
                out.print(listInt.get(i) + "\n");
            else
                out.print(listInt.get(i) + " ");
        }
        out.close();
        System.exit(0);
    }
    public static String genNum (int i)
    {
        String ret = Integer.toBinaryString(i);
        while (ret.length() < len)
        {
            ret = "0" + ret;
        }
        return ret;
    }
    public static boolean check(String num)
    {
        boolean flag = true;
        for (int i = 0; i < listInt.size(); i++)
        {
            if (!(ham(listString.get(i), num)))
            {
                flag = false;
                break;
            }
        }
        if (flag)
        {
            listString.add(num);
        }
        return flag;
    }
    public static boolean ham (String a, String b)
    {
        int total = 0;
        for (int i = 0; i < a.length(); i++)
        {
            if (a.charAt(i) != b.charAt(i))
                total++;
        }
        return total >= dist;
    }
}
