import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문제의 개수 입력
        int N = scanner.nextInt();

        // 각 문제의 채점 결과 입력
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }

        // 점수 계산
        int totalScore = 0;
        int consecutiveScore = 0;
        for (int i = 0; i < N; i++) {
            if (scores[i] == 1) {
                consecutiveScore++;
                totalScore += consecutiveScore;
            } else {
                consecutiveScore = 0;
            }
        }

        // 결과 출력
        System.out.println(totalScore);

        scanner.close();
    }
}
