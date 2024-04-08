import java.io.*;
import java.util.*;

/**
 * dp
 *
 */

public class Main {
    static int[] seq;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력

        int N = Integer.parseInt(br.readLine());

        seq = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        //모든 위치에서 LIS 탐색
        for (int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static int LIS(int N) {
        //만약 탐색하지 않던 위치의 경우 1로 초기화
        if (dp[N] == 0) {
            dp[N] = 1;

            //N 이전의 수들을 탐색
            for (int i = N - 1; i >= 0; i--) {
                //이전의 노드 중 seq[N]이 큰 경우
                if (seq[i] < seq[N]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }
        return dp[N];
    }
}