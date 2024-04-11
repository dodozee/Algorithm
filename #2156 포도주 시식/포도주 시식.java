import java.io.*;
import java.util.*;


/**
 * dp 
 warning : 마지막 잔을 꼭 마셔야하는 조건이 없어서 조심
 * 
 * 동적 계획법 - top-down : recursion
 */
public class Main {
    static Integer[] dp;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];

        if(N > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(dynamic(N));
    }

    private static int dynamic(int n) {

       if(dp[n]==null) {
           dp[n] = Math.max(Math.max(dynamic(n - 2), dynamic(n - 3) + arr[n - 1]) + arr[n], dynamic(n - 1));
       }
         return dp[n];
    }
}