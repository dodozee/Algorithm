import java.io.*;


public class Main {//박두지 화이팅!!
        static final int MOD = 1000000009;
    
	public static void main(String[] args) throws IOException{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringBuilder sb = new StringBuilder();
		int n = st(br.readLine());
		long[][] dp = new long[100001][4];
        
		dp[1][1] = 1; 
		dp[2][2] = 1; 
		dp[3][1] = 1; 
		dp[3][2] = 1; 
		dp[3][3] = 1;
		for(int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
		}
		
		for(int i = 0; i < n; i++) {
			int t = st(br.readLine());
			sb.append((dp[t][1] + dp[t][2] + dp[t][3]) % MOD + "\n");
		}
		
		System.out.println(sb);
	}
	public static int st(String str) {
        return Integer.parseInt(str);
    }
}