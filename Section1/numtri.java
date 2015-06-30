/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: numtri
*/

import java.util.*;
import java.io.*;

public class numtri
{
    //public static ArrayList<Integer> sums = new ArrayList<Integer>();
    public static int[] values = new int[1001];
    public static int[][] dp = new int[1001][1001];  // uses dp (memoization)
    
    public static void main (String[] args) throws IOException
    {
        //Scanner scan = new Scanner ((new File ("numtri.in")));
        BufferedReader scan = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        
        int rows = Integer.parseInt(scan.readLine());
        int[][] triangle = new int[rows][];
        for (int i = 0; i < dp.length; i++)
        {
            for (int k = 0; k < dp.length; k++)
                dp[i][k] = -1;
        }
        for (int i = 0; i < rows; i++)
        {
            triangle[i] = new int[i+1];
        }
        for (int i = 0; i < rows; i++)
        {
            StringTokenizer st = new StringTokenizer(scan.readLine());
            for (int k = 0; k <=i; k++)
                triangle[i][k] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < rows; i++)
        {
            dp[rows-1][i] = triangle[rows-1][i];
        }
        values[0] = triangle[0][0];
        out.println(search(triangle, 0, 0));
        //System.out.println(Collections.max(sums));
        out.close();
        System.exit(0);
        
    }
    public static int search (int[][] triangle, int row, int col)
    {
        if (dp[row][col] != -1)  // if value is already memoized -> return it
            return dp[row][col];
        else if (row < triangle.length)
        {
            //System.out.println("row: " + row + " col: " + col);
            return dp[row][col] = triangle[row][col] + Math.max(search(triangle, row+1, col), search(triangle, row+1, col+1)); // memoize and return value
        }
        else
            return 0; // will only happen when row is triangle.length - 1
        /*//int total = triangle[0][0];
        if (row == triangle.length - 1)
        {
             sums.add(sum());
             return;
        }
        for (int i = 0; i < 2; i++)
        {
            //System.out.println("row: " + row + " col: " + col + " value: " + triangle[row+1][col+i]);
            //total += triangle[row+1][col+i];
            values[row+1] = triangle[row+1][col+i];
            search(triangle, row+1, col+i);
            values[row+1] = 0;
            //total -= triangle[row+1][col+i];
        }*/
    }
    /*public static int sum ()
    {
        int sum = values[0];
        for (int i = 1; i < values.length; i++)
            sum += values[i];
        return sum;
    }*/
}
    