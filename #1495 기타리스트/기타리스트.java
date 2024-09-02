import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    static int N,S,M;
    static boolean [][] dp;
    static int [] V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        V = new int[N + 1];

        dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            
            V[i] = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    int minus = j - V[i];
                    int plus = j + V[i];

                    if (minus >= 0) dp[i][minus] = true;
                    if (plus <= M) dp[i][plus] = true;
                    
                }
            }
        }
        int answer = -1;
        
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }
}