import java.io.*;
import java.util.*;


/**
 * dp + dfs

 */
public class Main {

    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;// 방문하지 않은 곳은 -1로 초기화
            }
        }

        System.out.println(dfs(1, 1));
    }

    private static int dfs(int x, int y) {
        //도달했을 때
        if (x == M && y == N) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];//이미 방문한 곳이면 그 값을 반환(memorization)
        } else{
            dp[x][y] = 0;//방문한 곳은 0으로 초기화
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 1 || ny < 1 || nx > M || ny > N) continue;


                if(map[x][y] > map[nx][ny]){
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];
    }
}