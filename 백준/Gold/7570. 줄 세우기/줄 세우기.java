import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] DP = new int[n+1];
        int max = 0;
        for(int i=0;i<n;i++){
            DP[num[i]] = DP[num[i]-1] + 1;
            max = Math.max(max,DP[num[i]]);
        }
        bw.write(String.valueOf(n - max));
        bw.flush();		
        bw.close();
        br.close();
    }
}