import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws Exception {
      
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(String.format("You get %d piece(s) and your dad gets %d piece(s).\n", c/v, c%v));
        }
        System.out.print(sb.toString());
    }
}