
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new boolean[n + 1][n + 1];
        int[] arr = new int[n+1];

        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr, n);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (dp[x][y]) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
//            System.out.println(isPalindrome(arr, x, y) ? "1" : "0");


        }

        System.out.println(sb);


    }

    public static void solve(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true; //똑같은 위치는 무조건 true;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }
    }

//    private static boolean isPalindrome(int[] arr, int x, int y) {
//        while (x < y) {
//            if (arr[x] == arr[y]) {
//                x++;
//                y--;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
}
