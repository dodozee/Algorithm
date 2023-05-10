import java.util.*;
import java.io.*;

public class Main{//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] adj = new int[n][n];

        //인접 행렬 입력 받기

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //플로이드 와샬 algorithm 적용
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][k] == 1 && adj[k][j] == 1) {
                        adj[i][j]=1;
                    }
                }
            }
        }
        //결과 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
              System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}