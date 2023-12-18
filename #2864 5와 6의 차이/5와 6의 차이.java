import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        
        String maximumA = "";
        String maximumB = "";
        String minimumA = "";
        String minimumB = "";
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '5' || A.charAt(i) == '6') {
                minimumA += "5";
                maximumA += "6";
            } else {
                minimumA += A.charAt(i);
                maximumA += A.charAt(i);
            }
        }
        for (int i = 0; i < B.length(); i++) {
            if (B.charAt(i) == '5' || B.charAt(i) == '6') {
                minimumB += "5";
                maximumB += "6";
            } else {
                minimumB += B.charAt(i);
                maximumB += B.charAt(i);
            }
        }
        int minimum = Integer.parseInt(minimumA) + Integer.parseInt(minimumB);
        int maximum = Integer.parseInt(maximumA) + Integer.parseInt(maximumB);
        System.out.print(minimum + " " + maximum);
    }
}