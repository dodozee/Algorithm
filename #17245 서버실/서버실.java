import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        int[][] serverRoom = new int[N][N];
        long count = 0;
        int max = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                serverRoom[i][j] = Integer.parseInt(st.nextToken());
                
                count += serverRoom[i][j];
                
                if (max < serverRoom[i][j]) {
                    max = serverRoom[i][j];
                }
            }
        }

        int mid = 0;
        
        while (min + 1 < max) {
            mid = (min + max) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (serverRoom[i][j] > mid) {
                        cnt += mid;
                    } else {
                        cnt += serverRoom[i][j];
                    }
                }
            }

            if (((double) cnt / count) >= 0.5) {
                max = mid;
                
            } else {
                
                min = mid;
            }
        }
        System.out.println(max);
    }
}