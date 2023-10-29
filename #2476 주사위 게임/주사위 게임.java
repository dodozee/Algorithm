import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0; 
        int total = 0;  
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            if (x == y && z == y) {
                total = 10000 + x * 1000;
            } else if (x == y) {
                total = 1000 + x * 100;
            } else if (y == z) {
                total = 1000 + y * 100;
            } else if (z == x) {
                total = 1000 + z * 100;
            } else {
                total = Math.max(x, Math.max(y,z)) * 100;
            }
            max = Math.max(max, total);
        }
        System.out.print(max);
    }
}