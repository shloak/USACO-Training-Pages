/*
ID: shloak1
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;

class ride 
{
    public static void main (String ... orange) throws FileNotFoundException, IOException
    {
        Scanner scan = new Scanner (new File ("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();
        int counter1 = 1;
        int counter2 = 1;
        for (int i = 0; i < line1.length(); i++)
        {
            counter1 *= (int)line1.charAt(i)- (int)'A' + 1;
        }
        for (int k = 0; k < line2.length(); k++)
        {
            counter2 *= (int)line2.charAt(k) - (int)'A' + 1;
        }
        if (counter1 % 47 == counter2 % 47)
        {
            out.println("GO");
        }
        else
        {
            out.println("STAY");
        }
        out.close();
        System.exit(0);
    }
}
