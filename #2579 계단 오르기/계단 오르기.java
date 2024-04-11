import java.io.*;
import java.util.*;


/**
 * dp
 * 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다.
 * 계단에는 일정한 점수가 쓰여져 있는데 계단을 밟으면 그 계딴에 쓰여있는 점수를 얻게 된다.
 *
 * 동적 계획법 - top-down : 재귀
 */
public class Main {
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];// default value 가 null이니까 0으로 초기화
        dp[1] = arr[1]; //

        if(n >= 2){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(n));

    }

    private static int find(int n){
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 2), find(n - 3) + arr[n - 1]) + arr[n];
        }

        return dp[n];
    }
}