import java.io.*;
import java.util.*;


/**
 * dp
 * 동적 계획법 - bottom-up : 반복문
 */
public class Main {
    static Integer[][] dp;
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new Integer[N][N];
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dynamic(0, 0);

        System.out.println(dp[0][0]);
    }

    private static int dynamic(int depth, int idx) {

        if (depth == N - 1) {
            dp[depth][idx] = arr[depth][idx];
            return dp[depth][idx];
        }

        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(dynamic(depth + 1, idx), dynamic(depth+1, idx+1)) + arr[depth][idx];
        }

        return dp[depth][idx];
    }
}