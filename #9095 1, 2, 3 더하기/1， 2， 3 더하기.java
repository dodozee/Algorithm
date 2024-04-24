import java.io.*;
import java.util.*;


/**
 *
 */
public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];
            System.out.println(recur(n));
        }
    }

    private static int recur(int n) {
        if(n == 1)
            return 1;

        if(n == 2)
            return 2;

        if(n == 3)
            return 4;

        if(dp[n] != 0)
            return dp[n];

        return dp[n] = recur(n - 1) + recur(n - 2) + recur(n - 3);
    }

}