import java.util.Scanner;

public class Main {//박두지 화이팅!!!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int num = scanner.nextInt();
            sum += num * num;
        }

        int verificationNumber = sum % 10;
        System.out.println(verificationNumber);

        scanner.close();
    }
}
