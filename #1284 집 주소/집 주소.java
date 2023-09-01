import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            int totalWidth = 0; // 각 입력에 대한 호수판의 총 너비

            // 입력이 0인 경우 종료
            if (input.equals("0")) {
                break;
            }

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                // 숫자에 따른 너비 계산
                if (c == '1') {
                    totalWidth += 2;
                } else if (c == '0') {
                    totalWidth += 4;
                } else {
                    totalWidth += 3;
                }

                // 숫자 사이 여백 추가
                if (i < input.length() - 1) {
                    totalWidth += 1;
                }
            }

            // 경계 여백 추가
            totalWidth += 2;

            System.out.println(totalWidth);
        }
    }
}
