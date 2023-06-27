import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String octal = scanner.nextLine();

        // 8진수를 2진수로 변환
        String binary = convertOctalToBinary(octal);

        System.out.println(binary);
    }

    public static String convertOctalToBinary(String octal) {
        StringBuilder binary = new StringBuilder();

        // 8진수를 10진수로 변환 후, 10진수를 2진수로 변환
        for (int i = 0; i < octal.length(); i++) {
            int digit = Character.getNumericValue(octal.charAt(i));

            StringBuilder temp = new StringBuilder(Integer.toBinaryString(digit));
            // 2진수가 3자리 미만일 경우, 앞에 0 추가
            while (temp.length() < 3) {
                temp.insert(0, "0");
            }

            binary.append(temp);
        }

        // 변환된 2진수의 첫 번째 숫자가 0인 경우 제거
        while (binary.length() > 1 && binary.charAt(0) == '0') {
            binary.deleteCharAt(0);
        }

        return binary.toString();
    }
}
