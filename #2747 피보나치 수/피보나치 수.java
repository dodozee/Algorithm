import java.util.Scanner;

public class Main {//박두지 화이팅!!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        long result = fibonacci(n);
        System.out.println(result);
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long prev1 = 0;
        long prev2 = 1;
        long current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }
}
