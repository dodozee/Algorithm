import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력받은 정수 N
        int N = scanner.nextInt();
        
        // 2024의 배수인지 확인
        if (N % 2024 == 0 && N <= 100000) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}
