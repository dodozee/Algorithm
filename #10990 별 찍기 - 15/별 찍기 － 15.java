import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 1; i <= N; i++) {
            // 공백 출력
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }
            
            // 별 출력
            System.out.print("*");
            
            // 두 번째 줄부터 별 출력
            for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
                System.out.print(" ");
                if (j == 2 * (i - 1) - 1) {
                    System.out.print("*");
                }
            }
            
            System.out.println(); // 줄 바꿈
        }
    }
}
