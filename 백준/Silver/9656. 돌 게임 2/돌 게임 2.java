import java.util.Scanner;

/**
 * 돌게임 2는 DP를 이용해서 품
 * 상근이와 창영이가 턴을 번갈아가면서 돌을 들고가는 게임이다.
 * 돌은 1개나 3개씩 가져갈 수 있다. 그리고 마지막에 들고가는 사람이 패배한다.
 * 패배하는 사람을 출력하라.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        whoLose(N);

    }

    public static void whoLose(int N) {
        if (N == 1 || N == 3) {
            System.out.println("CY");
            return;
        } else if (N == 2) {
            System.out.println("SK");
            return;
        }

        int[] dp = new int[N + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }

        if (dp[N] % 2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }



    }
}
