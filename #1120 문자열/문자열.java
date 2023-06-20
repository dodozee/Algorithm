import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String leftWord = st.nextToken();
        String rightWord = st.nextToken();

        int lengthDifference = rightWord.length() - leftWord.length();
        
        int difference = leftWord.length();

        for (int i = 0; i < lengthDifference + 1; i++) {
            int tmp=0;
            for (int j = 0; j < leftWord.length(); j++) {
                if (leftWord.charAt(j) != rightWord.charAt(j + i)) {
                    tmp++;
                }
            }
            if (difference > tmp) {
                difference = tmp;
            }
        }

        System.out.println(difference);

    }
}