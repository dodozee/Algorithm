import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3]; // 각 집을 빨강, 초록, 파랑으로 칠하는 비용

        // 각 집을 빨강, 초록, 파랑으로 칠하는 비용 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j]는 i번 집을 j(0: 빨강, 1: 초록, 2: 파랑)으로 칠할 때의 최소 비용
        int[][] dp = new int[n][3];

        // 첫 번째 집은 초기 비용 그대로 설정
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        // 마지막 집을 빨강, 초록, 파랑 중에서 가장 작은 비용을 선택
        int minCost = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

        System.out.println(minCost);
    }
}
