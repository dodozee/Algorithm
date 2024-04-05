import java.io.*;
import java.util.*;

/**
 * StringBuilder를 사용하여 편리하게 deleteCharAt 메서드를 활용하자
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while (s.length() < t.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else if (t.charAt(t.length() - 1) == 'B') {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        System.out.println(t.toString().equals(s.toString()) ? 1 : 0);

    }
}