import java.util.Scanner;

public class Main{//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 개수 입력

        for (int i = 1; i <= T; i++) {
            int dice1 = scanner.nextInt(); // 첫 번째 주사위 값 입력
            int dice2 = scanner.nextInt(); // 두 번째 주사위 값 입력
            int sum = dice1 + dice2; // 주사위 두 개의 합

            System.out.println("Case " + i + ": " + sum);
        }

        scanner.close();
    }
}
