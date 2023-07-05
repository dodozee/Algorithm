import java.util.Scanner;

public class Main{//박두지 화이팅!!!

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // N과 M이 1인 경우 예외 처리
        if (n == 1 && m == 1) {
            System.out.println(0);
        } else {
            // 쪼개는 횟수는 초콜릿 조각의 개수 - 1이므로 N * M - 1을 출력
            System.out.println(n * m - 1);
        }

        scanner.close();
    }
}
