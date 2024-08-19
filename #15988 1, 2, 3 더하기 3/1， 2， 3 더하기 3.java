import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 1000001; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
		}
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}