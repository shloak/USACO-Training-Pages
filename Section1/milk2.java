/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package Section1;*/

/*
ID: shloak1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

public class milk2 {

    public int[] count;
    public int   startTime;
    public int   endTime;

    public static void main(String[] args) throws Exception {
        milk2 main = new milk2();
        main.solve();
        System.exit(0);
    }

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("milk2.out"));
        int N = Integer.parseInt(br.readLine());
        count = new int[1000001];
        startTime = 1000000;
        endTime = 0;
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split("\\s");
            int start = Integer.parseInt(strs[0]);
            int end = Integer.parseInt(strs[1]);
            startTime = Math.min(start, startTime);
            endTime = Math.max(end, endTime);
            for (int k = start; k < end; k++)
                count[k]++;
        }
        int maxTime1 = 0;
        int maxTime2 = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = startTime; i < endTime; i++) {
            if (count[i] > 0) {
                tmp1++;
                tmp2 = 0;
            }
            else {
                tmp2++;
                tmp1 = 0;
            }

            maxTime1 = Math.max(maxTime1, tmp1);
            maxTime2 = Math.max(maxTime2, tmp2);
        }
        out.write("" + maxTime1 + " " + maxTime2 + "\n");
        out.close();
    }
}