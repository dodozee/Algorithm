import java.io.*;
import java.util.*;


/**
 *
 * 냅색 알고리즘은 크게 2가지 문제로 분류
 * 1.짐을 쪼갤수 있는 경우(Fraction Knapsack Problem) -> 탐욕 알고리즘
 * 2.짐을 쪼갤수 없는 경우(0/1 Knapsack Problem -> DP 방식
 *
 * 이번 문제는 마찬가지로 짐을 쪼갤수가 없기 때문에 2번 DP로 해결
 *
 */
public class Main {

    static Integer[][] dp;
    static int[] W;
    static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];

        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recur(N-1, K));
    }

    private static int recur(int i, int k) {
        if(i<0)
            return 0;

        if (dp[i][k] == null) {
            if (W[i] > k) {
                dp[i][k] = recur(i - 1, k);
            }else{
                dp[i][k] = Math.max(recur(i - 1,k), recur(i - 1, k - W[i]) + V[i]);
            }
        }
        return dp[i][k];
    }

}