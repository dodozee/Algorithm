import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken()) + 1;
        long[] combinationCnt = new long[N+1];
        long[][] DP = new long[N+1][N+1];
        combinationCnt[0] = 1;
        for(int i=1;i<=N;i++){
            combinationCnt[i] = combinationCnt[i-1] * 2;
            DP[i][0] = 1;
        }

        for(int i=1;i<=N;i++) {
            DP[0][i] = DP[1][i - 1] + combinationCnt[i - 1];
            for (int j = 1; j <= N - i; j++) {
                DP[j][i] = DP[j - 1][i - 1] + DP[j + 1][i - 1];
            }
        }

        if((N % 2 == 1 && K > combinationCnt[N]) || (N % 2 == 0 && K > DP[0][N])){
            bw.write("-1");
        }else{
            StringBuilder sb = new StringBuilder();
            int len = 0;
            int leftCnt = 0;
            boolean flag = N % 2 == 1;
            while(len < N){
                if(flag){
                    if(K > combinationCnt[N-len-1]){
                        sb.append(")");
                        K -= combinationCnt[N-len-1];
                    }else{
                        sb.append("(");
                    }
                }else{
                    if(K > DP[leftCnt+1][N-len-1]){
                        sb.append(")");
                        K -= DP[leftCnt+1][N-len-1];
                        leftCnt--;
                    }else{
                        sb.append("(");
                        leftCnt++;
                    }
                }
                if(!flag && leftCnt < 0 ){
                    flag = true;
                }
                len++;
            }
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
