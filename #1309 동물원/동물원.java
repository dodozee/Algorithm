import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;// 초기값 설정 여기서 dp가 담고있는 값은 각각 0, 1, 2로 끝나는 경우의 수를 담고있다. 즉, 사자가 있어도 1 없어도 1로 포함.

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD; // 사자가 없는 경우는 이전에 사자가 있든 없든 상관없이 3가지 경우의 수가 있다.
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;// 사자가 왼쪽에 있는 경우는 이전에 사자가 없거나 오른쪽에 있을 경우의 수가 있다.
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;// 사자가 오른쪽에 있는 경우는 이전에 사자가 없거나 왼쪽에 있을 경우의 수가 있다.
        }

        long result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}


