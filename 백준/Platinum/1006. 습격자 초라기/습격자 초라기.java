import java.io.*;
import java.util.*;
 
public class Main {
 
    static final int INF = 1_000_000;
    static int[] a = new int[10001], b = new int[10001], c = new int[10001];
    static int[][] e = new int[2][10001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        tc: while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    e[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int ans = INF;
            set(N, (e[0][1] + e[1][1] <= W)? 1: 2, 1, 1);
            dp(N, W);
            ans = a[N];
            
            if (e[0][1] + e[0][N] <= W) {
                set(N, 1, 0, 1);
                dp(N, W);
                ans = Math.min(ans, c[N] + 1);
            }
            
            if (e[1][N] + e[1][1] <= W) {
                set(N, 1, 1, 0);
                dp(N, W);
                ans = Math.min(ans, b[N] + 1);
            }
            
            if (e[0][1] + e[0][N] <= W && e[1][1] + e[1][N] <= W) {
                set(N, 0, 0, 0);
                dp(N, W);
                ans = Math.min(ans, a[N-1] + 2);
            }    
            System.out.println(ans);
        }
    }
    
    static void set(int N, int a1, int b1, int c1) {
        Arrays.fill(a, 1, N+1, INF);
        Arrays.fill(b, 1, N+1, INF);
        Arrays.fill(c, 1, N+1, INF);
        a[1] = a1;
        b[1] = b1;
        c[1] = c1;
    }
    
    static void dp(int N, int W) {
        for (int i = 2; i <= N; i++) {
            b[i] = a[i-1] + 1;
            if (e[0][i-1] + e[0][i] <= W) b[i] = Math.min(b[i], c[i-1] + 1);
            
            c[i] = a[i-1] + 1;
            if (e[1][i-1] + e[1][i] <= W) c[i] = Math.min(c[i], b[i-1] + 1);
                            
            a[i] = Math.min(b[i] + 1, c[i] + 1);
            if (e[0][i] + e[1][i] <= W) 
                a[i] = Math.min(a[i], a[i-1] + 1);
            if (i>1 && e[0][i-1] + e[0][i] <= W && e[1][i-1] + e[1][i] <= W)
                a[i] = Math.min(a[i], a[i-2] + 2);
        }
    }
}