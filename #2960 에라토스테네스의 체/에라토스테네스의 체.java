import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        primeNumber(N,K);
    }
    static void primeNumber(int n, int k) {
        int[] array = new int[n+1]; 


       for (int i = 2; i <= n; i++) {
            array[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (array[i] == 0) continue;
            
            for (int j = i; j <= n; j+=i) {
                if (array[j] != 0) {
                    array[j] = 0;
                    k--;
                    
                    if (k == 0) {
                        System.out.print(j);
                        return;
                    }
                }
            }
        }
    }
}