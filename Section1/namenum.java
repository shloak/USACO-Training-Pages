/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: namenum
*/

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class namenum
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("namenum.in"));
        Scanner scan2 = new Scanner (new File ("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        char[][] combos = {{'a'}, {'a'}, {'A', 'B', 'C'}, {'D','E','F'}, {'G','H','I'}, {'J','K','L'}, 
            {'M', 'N', 'O'}, {'P', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y'}};
        boolean are = false;
        String numberString = scan.nextLine();
        BigInteger number = new BigInteger(numberString);
        int length = numberString.length();
        while (scan2.hasNextLine())
        {
            BigInteger temp = new BigInteger(numberString);
            boolean isValid = true;
            String line = scan2.nextLine();
            if (line.length() == length)
            {
                for (int i = 0; i < line.length(); i++)
                {
                    if (!(line.charAt(line.length()-1-i) == combos[temp.mod(new BigInteger("10")).intValue()][0] || line.charAt(line.length()-1-i) == combos[temp.mod(new BigInteger("10")).intValue()][1]
                            || line.charAt(line.length()-1-i) == combos[temp.mod(new BigInteger("10")).intValue()][2]))
                    {
                        isValid = false;
                        break;
                    }
                    temp = temp.divide(new BigInteger("10"));
                }
                if (isValid)
                {
                    are = true;
                    out.println(line);
                }
            }
        }
        if (!are)
            out.println("NONE");
        out.close();
        System.exit(0);
    }
}
