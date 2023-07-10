import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // N 입력

        // N부터 1까지 감소하면서 가장 큰 금민수 찾기
        for (int i = N; i >= 1; i--) {
            // 금민수인지 확인
            if (isGumminsu(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    // 금민수인지 확인하는 함수
    private static boolean isGumminsu(int num) {
        // num을 문자열로 변환하여 각 자릿수 확인
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            char digit = strNum.charAt(i);
            // 4와 7 이외의 숫자가 나오면 금민수가 아님
            if (digit != '4' && digit != '7') {
                return false;
            }
        }
        return true;
    }
}
