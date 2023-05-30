import java.util.*;
import java.io.*;

public class Main{ //박두지 화이팅!!
    static int n;//대나무 숲의 크기
    static int[][] forest;// 대나무 숲의 정보
    static int[][] dp;//각 칸에서 시작하는 최대 이동 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        forest = new int[n][n];
        dp = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxDistance = 0;//최대 이동 거리

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int distance = dfs(i, j);
                maxDistance = Math.max(maxDistance, distance);
            }
        }

        System.out.println(maxDistance);


    }

    static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int maxDistance = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && forest[nx][ny] > forest[x][y]) {
                int distance = dfs(nx, ny) + 1; //이동한 칸에서 최대 이동거리 + 1
                maxDistance = Math.max(maxDistance, distance);
            }
        }

        dp[x][y] = maxDistance; // 현재 칸에서 시작하는 최대 이동 거리 저장

        return maxDistance;
    }
}