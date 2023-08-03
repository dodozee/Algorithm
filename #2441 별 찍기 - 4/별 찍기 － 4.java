import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            // 공백 출력
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // 별 출력
            for (int j = 0; j < N - i; j++) {
                System.out.print("*");
            }

            // 줄 바꿈
            System.out.println();
        }
    }
}
