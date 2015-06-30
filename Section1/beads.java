/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
ID: shloak1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;
        
public class beads 
{
    public static void main (String[] args) throws IOException
    {
        Scanner scan = new Scanner (new File ("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int a = scan.nextInt();
        String x = scan.nextLine();
        String necklace = scan.nextLine();
        char[] array = necklace.toCharArray();
        int current1 = 0;
        int current2 = 0;
        int largest = 0;
        if (a <= 3 || allAreSame (array))
            largest = a;
        else
        {
            for (int i = 0; i < array.length; i += current1)
            {
                current2 = current1;
                current1 = 0;
                char at = array[i];
                int it = i;
                while (array[it] == at || array[it] == 'w')
                {
                    current1++;
                    it = (it+1)%(array.length);
                    if (current1 + current2 >= a)
                    {
                        //largest = current1 + current2;
                        break;
                    }
                }
                if (i == 0)
                {
                    at = array[array.length-1];
                    it = array.length-1;
                    while (array[it] == at || array[it] == 'w')
                    {
                        current2++;
                        if (it == 0)
                            it = array.length-1;
                        else
                            it--;
                        if (current1 + current2 >= a)
                        {
                            //largest = current1 + current2;
                            break;
                        }
                    }
                }
                else
                {
                    int z = array.length-1;
                    if (i-1-current2 > 0)
                        z = i-1-current2;
                    while (array[z] == 'w')
                    {
                        current2++;
                        if (z == 0)
                        {
                            z = array.length-1;
                        }
                        else
                        {
                            z--;
                        }
                        if (current1 + current2 >= a)
                        {
                            break;
                        }
                    }
                }
                if (current1 + current2 > largest)
                    largest = current1+current2;
                if (largest >= array.length - 2)
                    break;
            }    
        }
        out.println(largest);
        out.close();
        System.exit(0);
    }
    public static boolean allAreSame (char[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] != array[i-1])
            {
                return false;
            }
        }
        return true;
    }
}
