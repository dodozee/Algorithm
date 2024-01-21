import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        System.out.println(process());
    }
   
    static int process(){
        if(N == 1) return 1;
        if(N == 2) return Math.min(4, (M+1)/2);
        if(M<7) return Math.min(4, M);
        return M-2;
    }
}