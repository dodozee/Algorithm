import java.io.*;

public class Main {
    static int cnt = 0;
    static int dpCnt = 0;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        fib(n);
        fibonacci(n);
        System.out.println(cnt);
        System.out.println(dpCnt);
    }

    
    private static int fibonacci(int n) {
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dpCnt++;
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }
    private static int fib(int n) {

        if(n == 1 || n == 2){
            cnt++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}