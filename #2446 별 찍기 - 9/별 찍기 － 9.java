import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 별이 하나씩 감소하는 부분 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * N - 1 - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 별이 하나씩 증가하는 부분 출력
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * N - 1 - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
