import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        scanner.close();

        String result = canUseLuckyStraight(score);
        System.out.println(result);
    }

    public static String canUseLuckyStraight(int score) {
        String scoreStr = String.valueOf(score);
        int length = scoreStr.length();

        int leftSum = 0;
        int rightSum = 0;

        // 왼쪽 부분 자릿수의 합 계산
        for (int i = 0; i < length / 2; i++) {
            leftSum += scoreStr.charAt(i) - '0'; // char to int
        }

        // 오른쪽 부분 자릿수의 합 계산
        for (int i = length / 2; i < length; i++) {
            rightSum += scoreStr.charAt(i) - '0'; // char to int
        }

        if (leftSum == rightSum) {
            return "LUCKY";
        } else {
            return "READY";
        }
    }
}
