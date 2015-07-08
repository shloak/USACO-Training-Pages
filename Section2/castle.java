/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section2;*/

/*
ID: shloak1
LANG: JAVA
TASK: castle
*/

import java.util.*;
import java.io.*;

public class castle
{
    public static int[][] values;
    public static int[] Ns;
    public static boolean[][] visited;
    public static int[][] current;
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader scan = new BufferedReader(new FileReader("castle.in"));
        //Scanner scan = new Scanner (System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer st = new StringTokenizer(scan.readLine());
        int M = Integer.parseInt(st.nextToken());
        //int M = scan.nextInt();
        //int N = scan.nextInt();
        int N = Integer.parseInt(st.nextToken());
        values = new int[N][M];
        Ns = new int[N*M+1];
        visited = new boolean[N][M];
        current = new int[N][M];
        for (int i = 0; i < N; i++)
        {
            StringTokenizer s = new StringTokenizer(scan.readLine());
            for (int k = 0; k < M; k++)
            {
                values[i][k] = Integer.parseInt(s.nextToken());
                //values[i][k] = scan.nextInt();
            }
        }
        int val = 0;
        for (int i = 0; i < N; i++)
        {
            for (int k = 0; k < M; k++)
            {
                if (!visited[i][k])
                {
                    search(i, k, ++val);
                }
            }
        }
        int numRooms = val;
        int maxRoom = 0;
        for (int i = 1; i <= numRooms; i++)
        {
            maxRoom = Math.max(maxRoom, Ns[i]);
        }
        int maxSize = 0;
        char dir = 'N';
        int locX = 0, locY = 0;
        for (int i = 0; i < M; i++)
        {
            for (int k = N-1; k > -1; k--)
            {
                if (k != 0 && current[k][i] != current[k-1][i])
                {
                    if (Ns[current[k][i]] + Ns[current[k-1][i]] > maxSize)
                    {
                        maxSize = Ns[current[k][i]] + Ns[current[k-1][i]];
                        dir = 'N';
                        locX = k+1;
                        locY = i+1;
                    }
                }
                if (i != M-1 && current[k][i] != current[k][i+1])
                {
                    if (Ns[current[k][i]] + Ns[current[k][i+1]] > maxSize)
                    {
                        maxSize = Ns[current[k][i]] + Ns[current[k][i+1]];
                        dir = 'E';
                        locX = k+1;
                        locY = i+1;
                    }
                }
            }
        }
        out.println(numRooms);
        out.println(maxRoom);
        out.println(maxSize);
        out.println(locX + " " + locY + " " + dir);
        out.close();
        System.exit(0);
    }
    public static void search (int x, int y, int n)
    {
        if (!visited[x][y])
        {
            visited[x][y] = true;
            current[x][y] = n;
            Ns[n]++;
            if (values[x][y] == 0)
            {
                search(x-1, y, n);
                search(x, y+1, n);
                search(x, y-1, n);
                search(x+1, y, n);
            }
            if (values[x][y] == 1)
            {
                search(x-1, y, n);
                search(x, y+1, n);
                search(x+1, y, n);
            }
            else if (values[x][y] == 2)
            {
                search(x, y-1, n);
                search(x, y+1, n);
                search(x+1, y, n);
            }
            else if (values[x][y] == 4)
            {
                search(x-1, y, n);
                search(x, y-1, n);
                search(x+1, y, n);
            }
            else if (values[x][y] == 8)
            {
                search(x-1, y, n);
                search(x, y+1, n);
                search(x, y-1, n);
            }
            else if (values[x][y] == 3)
            {
                search(x, y+1, n);
                search(x+1, y, n);
            }
            else if (values[x][y] == 5)
            {
                search(x-1, y, n);
                search(x+1, y, n);
            }
            else if (values[x][y] == 9)
            {
                search(x-1, y, n);
                search(x, y+1, n);
            }
            else if (values[x][y] == 6)
            {
                search(x, y-1, n);
                search(x+1, y, n);
            }
            else if (values[x][y] == 10)
            {
                search(x, y-1, n);
                search(x, y+1, n);
            }
            else if (values[x][y] == 12)
            {
                search(x-1, y, n);
                search(x, y-1, n);
            }
            else if (values[x][y] == 7)
            {
                search(x+1, y, n);
            }
            else if (values[x][y] == 11)
            {
                search(x, y+1, n);
            }
            else if (values[x][y] == 13)
            {
                search(x-1, y, n);
            }
            else if (values[x][y] == 14)
            {
                search(x, y-1, n);
            }
        }
    }
}
