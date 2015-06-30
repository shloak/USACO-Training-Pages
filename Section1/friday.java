
import java.io.*;
import java.util.*;

/*
ID: shloak1
LANG: JAVA
TASK: friday
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package Section1;

/**
 *
 * @author Shloak
 */
class friday 
{
    public static void main (String ... orange) throws IOException
    {
        Scanner scan = new Scanner (new File ("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int num = scan.nextInt();
        int[] array = new int[7];  // saturday - monday 
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days1 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int counter = 2;
        for (int i = 1900; i < 1900 + num; i++)
        {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0))
            {
                for (int k = 0; k < 12; k ++)
                {
                    array[(counter+12)%7]++;
                    counter = ((counter+days1[k])%7);
                }
            }
            else
            {
                for (int k = 0; k < 12; k++)
                {
                    array[(counter+12)%7]++;
                    counter = ((counter+days[k])%7);
                }
            }
        }
        out.print(array[0]);
        for (int i = 1; i < 7; i++)
            out.print(" " + array[i]);
        out.print("\n");
        out.close();
        System.exit(0);
    }
}
