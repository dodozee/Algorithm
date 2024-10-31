

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] cost = new int[2][n];
            int[][] dp = new int[2][n];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                cost[0][i] = Integer.parseInt(st1.nextToken());
                cost[1][i] = Integer.parseInt(st2.nextToken());
            }

            dp[0][0] = cost[0][0];
            dp[1][0] = cost[1][0];

            int max = Math.max(dp[0][0], dp[1][0]); //첫번째 최대값 스티커를 선택

            for (int i = 1; i < n; i++) {
                if (i == 1) {
                    dp[0][i] = dp[1][0] + cost[0][i];
                    dp[1][i] = dp[0][0] + cost[1][i];
                    max = Math.max(dp[0][i], dp[1][i]);
                } else {
                    dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + cost[0][i];
                    dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + cost[1][i];
                    max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
                }

            }
            sb.append(max).append("\n");
        }


        System.out.println(sb);
    }
}

