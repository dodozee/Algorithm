import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String N = scanner.next();

        long remainder = 0;
        for (int i = 0; i < N.length(); i++) {
            remainder = (remainder * 10 + (N.charAt(i) - '0')) % 20000303;
        }

        System.out.println(remainder);
    }
}
