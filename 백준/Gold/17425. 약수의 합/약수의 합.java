import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAX = 1_000_001;
	public static void main(String[] args) throws IOException{
		long[] cSum = getDivisorSum();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			sb.append(cSum[Integer.parseInt(br.readLine())]+"\n");
		}
		System.out.println(sb.toString());
	}
	
	private static long[] getDivisorSum() {
		long[] dp = new long[MAX];
		Arrays.fill(dp, 1);
		for(int i=2; i<MAX; i++) {
			for(int j=1; i*j<MAX; j++) {
				dp[i*j] += i;
			}
		}
		
		long[] cSum = new long[MAX];
		for(int i=1; i<MAX; i++) {
			cSum[i] = cSum[i-1] + dp[i];
		}
		return cSum;
	}
}