import java.io.*;
import java.util.*;


/**
 * 점화식을 세우면 피보나치 수열이 나온다.
 */
public class Main {

    static Integer[] dp = new Integer[10000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;


        System.out.println(method(N));


    }

    private static int method(int n) {


        if (dp[n] == null) {
        dp[n] = (method(n - 1) + method(n - 2))% 15746;
        }


        return dp[n];
    }

}