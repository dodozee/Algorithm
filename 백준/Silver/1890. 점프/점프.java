import java.util.*;

public class Main {
	static int n;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n= s.nextInt();
		int list[][] = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				list[i][j] = s.nextInt();
			}
		}
		
		long dp[][] = new long[n+1][n+1]; 
		dp[1][1]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int next = list[i][j];
				if(next==0) break;
				if(j+next<=n) dp[i][j+next] += dp[i][j];
				if(i+next<=n) dp[i+next][j] += dp[i][j];
			}		
			
		}
		System.out.println(dp[n][n]);
	}
	 public static void print(long[][] dp){
	        for(int i=1; i<=n; i++){
	            for(int j=1; j<=n; j++){
	                System.out.print(dp[i][j]+" ");
	            }
	        System.out.println();
	        }
	        
	  }
}