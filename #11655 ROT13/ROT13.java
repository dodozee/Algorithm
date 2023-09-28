import java.util.Scanner;

public class Main {//박두지화이팅
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = rot13(input);
        System.out.println(result);
        scanner.close();
    }

    public static String rot13(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append((char) (((c - 'A' + 13) % 26) + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) (((c - 'a' + 13) % 26) + 'a'));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
