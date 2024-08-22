import java.util.*;
public class Main{
    static long dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dp = new long[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = -1;
            } 
        } 
        System.out.println(dp(n, m)%1000000007);
    }
        private static long dp(int n, int m) {
        if (m==0||n==0) 
            return 0;
        if (m==1&&n==1) 
            return 1;
        if (dp[n][m]!=-1) 
            return dp[n][m];
        long result = (dp(n, m-1) + dp(n-1, m) + dp(n-1, m-1))%1000000007;
        dp[n][m] = result;
        return result;
    }
}