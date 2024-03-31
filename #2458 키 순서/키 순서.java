import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1; //0부터 시작
            int y = Integer.parseInt(st.nextToken())-1; //0부터 시작
            check[x][y] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++){
                    if(check[j][i] && check[i][k]){ // j->i, i->k
                        check[j][k] = true;
                    }
                }
            }
        }

        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] || check[j][i]) {
                    cnt[i]++;
                }
            }
        }

        int res = 0;
        for (int num : cnt) {
            if (num == n - 1) {
                res++;
            }
        }

        System.out.println(res);

    }
}

