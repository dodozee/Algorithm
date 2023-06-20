import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();


        // LCS 길이 계산
        int lcsLength = calculateLCSLength(str1, str2);

        // 결과 출력
        System.out.println(lcsLength);
    }

    // LCS 길이 계산 함수
    private static int calculateLCSLength(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // LCS 길이 계산
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[str1.length()][str2.length()];
    }
}
