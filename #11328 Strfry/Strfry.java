import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String answer = "Possible";

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            answer = strfry(st.nextToken(), st.nextToken());
            System.out.println(answer);
        }
    }

    public static String strfry(String bfStr, String afStr) {

        if(bfStr.length() != afStr.length()) return "Impossible";

        int befArr[] = new int[26];
        int aftArr[] = new int[26];

        for(int i = 0; i < bfStr.length(); i++) {
            befArr[bfStr.charAt(i) - 'a']++;
            aftArr[afStr.charAt(i) - 'a']++;
        }

        for(int i = 0; i < befArr.length; i++) {
            if(befArr[i] != aftArr[i]) return "Impossible";
        }

        return "Possible";
    }
}