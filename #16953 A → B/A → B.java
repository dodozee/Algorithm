import java.util.*;
import java.io.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int ans = 1;
        while (B != A) {
            if (B < A) {
                ans = -1;
                break;
            }
            String str = String.valueOf(B);
            
            if (str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
                ans = -1;
                break;
            }
            if (B % 2 == 0) { 
                B >>= 1;
            } else { 
                str = str.substring(0, str.length() - 1);
                B = Long.parseLong(str);
            }

            ans++; 
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
       
    }

}
 