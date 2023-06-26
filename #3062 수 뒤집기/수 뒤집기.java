import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt(); // 정수 N

            int reversedN = reverseNumber(N); // N을 뒤집은 수

            int sum = N + reversedN; // N과 뒤집은 수를 합한 수

            String result = isSymmetric(sum) ? "YES" : "NO"; // 좌우 대칭 여부 확인

            System.out.println(result);
        }
    }

    // 숫자를 뒤집는 메서드
    private static int reverseNumber(int num) {
        int reversed = 0;

        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        return reversed;
    }

    // 수가 좌우 대칭인지 확인하는 메서드
    private static boolean isSymmetric(int num) {
        String str = String.valueOf(num);
        int len = str.length();

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
