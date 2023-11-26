import java.util.Scanner;

public class Main {//박두지 화이팅
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스의 개수 입력
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            // 거스름돈 입력
            int C = scanner.nextInt();

            // 각 동전의 개수 계산
            int quarters = C / 25;
            int dimes = (C % 25) / 10;
            int nickels = ((C % 25) % 10) / 5;
            int pennies = ((C % 25) % 10) % 5;

            // 출력
            System.out.println(quarters + " " + dimes + " " + nickels + " " + pennies);
        }

        scanner.close();
    }
}
