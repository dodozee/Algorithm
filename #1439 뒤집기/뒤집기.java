import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cnt0 = 0; // 0을 뒤집는 횟수
        int cnt1 = 0; // 1을 뒤집는 횟수

        // 첫 번째 숫자 처리
        if (s.charAt(0) == '0') {
            cnt1++;
        } else {
            cnt0++;
        }

        // 연속된 숫자 그룹 처리
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (s.charAt(i) == '0') {
                    cnt1++;
                } else {
                    cnt0++;
                }
            }
        }

        // 뒤집는 횟수가 적은 값을 출력
        System.out.println(Math.min(cnt0, cnt1));
    }
}