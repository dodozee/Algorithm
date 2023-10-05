import java.util.Scanner;

public class Main { //박두지 화이팅!!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int revX = reverseNumber(X);
        int revY = reverseNumber(Y);

        int result = revX + revY;
        int revResult = reverseNumber(result);

        System.out.println(revResult);

        scanner.close();
    }

    // 숫자의 자리수를 역순으로 만드는 함수
    private static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
}
