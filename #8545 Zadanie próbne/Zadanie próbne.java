import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String reverse = reverse(str);

        System.out.println(reverse);

    }

    private static String reverse(String reverse) {
        return new StringBuilder(reverse).reverse().toString();
    }
}
