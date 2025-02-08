import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());
        String[] arr = new String[T];
        String str = "";

        for (int i = 0; i < T; i++) {
            str = br.readLine();
            System.out.println(palindrome(0, str.length()- 1, str, 0));
        }
    }

    private static int palindrome(int start, int end, String s, int check) {
        if (check >= 2) {
            return 2;
        }

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return Math.min(palindrome(start + 1, end, s, check + 1), palindrome(start, end - 1, s, check + 1));
            }
        }
        return check;
    }
}