import java.util.Scanner;

public class Main {//박두지 화이팅
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }

            String decoded = reverseString(line);
            System.out.println(decoded);
        }

        scanner.close();
    }

    // 문자열을 역순으로 변환하는 메서드
    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
