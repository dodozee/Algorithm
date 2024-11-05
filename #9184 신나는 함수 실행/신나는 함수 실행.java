

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석
DP 특징은 대체로 재귀 + 메모이제이션을 사용한다.

 */
public class Main {
    static int[][][] dp = new int[21][21][21]; //메모이제이션을 위한 배열
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //종료 조건
            if(a==-1 && b==-1 && c==-1)
                break;

            sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
        }

        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        if (inRange(a,b,c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) return 1;
        /*
        a,b,c 중 하나라도 20보다 크다면 w(20,20,20)을 호출하기 때문에
        dp[20][20][20]에 저장하고 반환하면 된다.
         */
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }


        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}

