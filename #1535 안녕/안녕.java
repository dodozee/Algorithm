import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int hp = 99; // 안녕할 수 있는 체력

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[][] dp = new int[n + 1][hp + 1];
        //w는 체력이 닳는 양, v는 얻는 기쁨
        int[] w = new int[n+1];
        int[] v = new int[n+1];

        for(int i = 1; i <= n; i++) {

            w[i] = Integer.parseInt(st1.nextToken());
            v[i] = Integer.parseInt(st2.nextToken());

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= hp; j++) {
                if (w[i] <= j) { //소비되는 체력 <= 남은 체력 이라면(즉, 아직 더 걸을 수 있다면)
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);//이전값과 비교해서 큰값을 저장한다.
                } else {
                    dp[i][j] = dp[i-1][j];//이전값을 그대로 가져온다.
                }
            }
        }

        System.out.println(dp[n][hp]);



    }
}