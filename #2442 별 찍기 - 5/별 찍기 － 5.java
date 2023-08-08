import java.util.Scanner;

public class Main {//박두지 화이팅~~
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            // 왼쪽 공백 출력
            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println(); // 줄바꿈
        }

        sc.close();
    }
}
