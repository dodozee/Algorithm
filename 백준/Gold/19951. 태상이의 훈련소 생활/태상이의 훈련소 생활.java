import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n+1];
		for(int i=1; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+2];
		for(int t=0; t<m; t++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int k = sc.nextInt();
			
			dp[start] = dp[start]+k;
			dp[end+1] = dp[end+1]-k;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<arr.length; i++) {
			dp[i] = dp[i]+dp[i-1];
			sb.append((arr[i]+dp[i])+ " ");
		}
		
		System.out.println(sb.toString());
		
	}
}