import java.io.*;
import java.util.*;

public class Main {
    static Integer[] dp;
    static int[][] wire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int T = Integer.parseInt(input);
        dp = new Integer[T+1];
        wire = new int[T+1][2];
        StringTokenizer st;
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            wire[i][0] = a;
            wire[i][1] = b;
        }

        Arrays.sort(wire, Comparator.comparingInt(o -> o[0]));


        int max = 0;

        for (int i = 1; i <=T; i++) {
            max = Math.max(recur(i), max);
        }

        System.out.println(T - max);
    }
    static int recur(int N){
        if (dp[N] == null) {
            dp[N] = 1;

            for (int i = N + 1; i <dp.length; i++) {
                /*
                A 전봇대의 N번째 전선이 연결되어있는 B 전봇대보다 A의 i번째 전봇대의 전선이 이어진 B전봇대가 뒤에 있을 경우
                전선 설치 가능
                 */
                if (wire[N][1] < wire[i][1]) {
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }
        return dp[N];
    }
}


