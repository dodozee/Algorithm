import java.util.Scanner;
import java.io.*;

public class Main{ //가천대 컴공 20학번 화이팅~~
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();//횟수 선택...

        for (int i = 0; i < n; i++) {
            String x = s.next();
            int length = x.length();
            String first = String.valueOf(x.charAt(0)); //문자열인 x의 첫번째 인덱스인를 반환
            String last = String.valueOf(x.charAt(length - 1));//마지막 인덱스를 반환
            System.out.println(first + last);
        }

    }
}
