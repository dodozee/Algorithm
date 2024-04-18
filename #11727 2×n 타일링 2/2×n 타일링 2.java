import java.io.*;
import java.util.*;


/**
 * 점화식은 dp[n] = dp[n-1] + dp[n-2] x 2 이다.
 */
public class Main {//박두지 화이팅

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i -2] *2 ) % 10007;
        }

        System.out.println(dp[n]);
        
    }
}