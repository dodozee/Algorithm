import java.util.Scanner;

public class Main {//박두지 화이팅!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 문자열의 총 개수

        for (int i = 0; i < N; i++) {
            String password = scanner.next(); // 문자열 입력

            // 문자열 길이와 비밀번호 규칙을 확인하여 출력
            if (isValidPassword(password)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        scanner.close();
    }

    // 비밀번호 규칙을 확인하는 함수
    private static boolean isValidPassword(String password) {
        int length = password.length();

        // 비밀번호는 6자리 이상 9자리 이하여야 함
        if (length >= 6 && length <= 9) {
            // 문자열이 숫자, 영어 대소문자로만 구성되어야 함
            if (password.matches("[0-9a-zA-Z]+")) {
                return true;
            }
        }
        
        return false;
    }
}
