import java.io.*;
import java.util.*;

public class Main { // 박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxium = 0;
        int now = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            
            now -= out;
            now += in;
            
            maxium = Math.max(maxium, now);
        }
        System.out.print(maxium);
    }
}