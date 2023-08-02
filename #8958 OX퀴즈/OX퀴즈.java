import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String quizResult = scanner.nextLine().trim();
            int score = calculateScore(quizResult);
            System.out.println(score);
        }
    }

    public static int calculateScore(String quizResult) {
        int score = 0;
        int consecutiveO = 0;

        for (char c : quizResult.toCharArray()) {
            if (c == 'O') {
                consecutiveO++;
                score += consecutiveO;
            } else {
                consecutiveO = 0;
            }
        }

        return score;
    }
}
