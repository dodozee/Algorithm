import java.io.*;
import java.util.*;


/**
 * 점화식은 dp[n] = dp[n-1] + dp[n-2] 이다.
 */
public class Main {
    static Long[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new Long[N+1];

        dp[0] = 0L;
        dp[1] = 1L;

        System.out.println(recur(N));

    }

    private static long recur(int num) {
        if(dp[num] == null) {
            dp[num] = recur(num-1) + recur(num-2);
        }
        return dp[num];

    }
}