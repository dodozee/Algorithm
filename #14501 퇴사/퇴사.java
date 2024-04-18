import java.io.*;
import java.util.*;


/**
 */
public class Main {
    static int result;
    static int[][] schedule;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        schedule = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 걸리는 일 수
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 페이
        }

        recur(0, 0);
        
        System.out.println(result);

    }

    private static void recur(int t, int pay) {
        if(t >= N) {
            result = Math.max(pay, result);
            return;
        }

        if (t + schedule[t][0] <= N) {
            recur(t + schedule[t][0], pay + schedule[t][1]);
        }else{
            recur(t + schedule[t][0], pay);
        }

        recur(t + 1, pay);

    }
}