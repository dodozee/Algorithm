import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int diff = e - c;  
            if (r > diff) {
                sb.append("do not advertise\n");
            } else if (r == diff) {
                sb.append("does not matter\n");
            } else {
                sb.append("advertise\n");
            }
        }
        System.out.println(sb);
    }
}