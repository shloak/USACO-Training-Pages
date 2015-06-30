/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: crypt1
*/

import java.util.*;
import java.io.*;

public class crypt1
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int num = scan.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++)
            numbers[i] = scan.nextInt();
        Arrays.sort(numbers);
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
                            if (isValid(numbers[e]*(numbers[a]*100+numbers[b]*10+numbers[c]), numbers) &&
                                    isValid(numbers[d]*(numbers[a]*100+numbers[b]*10+numbers[c]), numbers) &&
                                    isValid((numbers[d]*10+numbers[e])*(numbers[a]*100+numbers[b]*10+numbers[c]), numbers) &&
                                    numbers[e]*(numbers[a]*100+numbers[b]*10+numbers[c]) < 1000 &&
                                    numbers[d]*(numbers[a]*100+numbers[b]*10+numbers[c]) < 1000 &&
                                    (numbers[d]*10+numbers[e])*(numbers[a]*100+numbers[b]*10+numbers[c]) < 10000)
                            {
                                works++;
                            }
                        }
                    }
                }
            }
        }
        /*int currentA, currentB, currentC, currentD, currentE;
        for (int c = 0; c < num; c++)
        {
            currentC = numbers[c];
            for (int e = 0; e < num; e++)
            {
                currentE = numbers[e];
                if (isValidSingle(currentC*currentE, numbers))
                {
                    for (int b = 0; b < num; b++)
                    {
                        currentB = numbers[b];
                        if (isValidSingle(((currentE*currentB) + ((currentC*currentE)/10)), numbers))
                        {
                            for (int a = 0; a < num; a++)
                            {
                                currentA = numbers[a];
                                if (isValidSingle((currentE*currentA) + (((currentE*currentB) + ((currentC*currentE)/10))/10), numbers)
                                        && ((currentE*currentA) + (((currentE*currentB) + ((currentC*currentE)/10))/10)) < 10)
                                {
                                    for (int d = 0; d < num; d++)
                                    {
                                        currentD = numbers[d];
                                        if (((currentA*currentD + (currentD*currentB+(currentD*currentC)/10)/10) < 10) && 
                                                isValidSingle((currentA*currentD + (currentD*currentB+(currentD*currentC)/10)/10), numbers) &&
                                                isValidSingle((currentD*currentB+(currentD*currentC)/10), numbers) &&
                                                isValidSingle(currentD*currentC, numbers) &&
                                                isValidSingle(currentD*currentC + currentE*currentB + (currentE*currentC)/10, numbers) &&
                                                isValidSingle((currentD*currentB + (currentD*currentC)/10 + currentE*currentA + (currentE*currentB + (currentE*currentC)/10)/10) +
                                                       (currentD*currentC + currentE*currentB + (currentE*currentC)/10)/10 , numbers) && 
                                                isValidSingle((currentA*currentD + (currentD*currentB+(currentD*currentC)/10)/10) + 
                                                    ((currentD*currentB + (currentD*currentC)/10 + currentE*currentA + (currentE*currentB + (currentE*currentC)/10)/10) +
                                                    (currentD*currentC + currentE*currentB + (currentE*currentC)/10)/10)/10, numbers))
                                        {
                                            works++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }*/
        out.println(works);
        out.close();
        System.exit(0);
    }
    /*public static boolean isValidSingle (int a, int[] numbers)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            if (a%10 == numbers[i])
                return true;
        }
        return false;
    }*/
    public static boolean isValid (int a, int[] numbers)
    {
        while (a > 0)
        {
            if (!check (a%10, numbers))
                return false;
            a = a/10;
        }
        return true;
    }
    public static boolean check (int a, int[] numbers)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == a)
                return true;
        }
        return false;
    }
}
