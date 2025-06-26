import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] sum = new int[N+1];	
        int[][] DP = new int[4][N+1];	
        for(int i=1;i<=N;i++)
            sum[i] += sum[i-1] + Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for(int i=1;i<4;i++){
            for(int j=i * M;j<=N;j++)
                DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j-M] + sum[j] - sum[j-M]);
        }
        bw.write(String.valueOf(DP[3][N]));	
        bw.flush();		

    }
}