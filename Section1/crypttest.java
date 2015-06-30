/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: crypttest
*/

import java.util.*;
import java.io.*;

public class crypttest
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (System.in/*new File ("crypt1.in")*/);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int num = scan.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++)
            numbers[i] = scan.nextInt();
        int works = 0;
        for (int a = 0; a < num; a++)
        {
            for (int b = 0; b < num; b++)
            {
                for (int c = 0; c < num; c++)
                {
                    for (int d = 0; d < num; d++)
                    {
                        for (int e = 0; e < num; e++)
                        {
                            if (isValidSingle((numbers[e]*(numbers[a]*100+numbers[b]*10+numbers[c]))%10, numbers) &&
                                    isValidSingle((numbers[e]*(numbers[a]*100+numbers[b]*10+numbers[c]))/10%10, numbers) &&
                                    isValidSingle((numbers[e]*(numbers[a]*100+numbers[b]*10+numbers[c]))/10/10%10, numbers))
                                break;
                        }
                    }
                }
            }
        }
    }
    public static boolean isValidSingle (int a, int[] numbers)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            if (a%10 == numbers[i])
                return true;
        }
        return false;
    }
}
