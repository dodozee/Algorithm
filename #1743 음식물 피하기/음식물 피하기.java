import java.util.Scanner;

public class Main {//박두지 화이팅!!!!

    static int N, M, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            map[r][c] = true;
        }

        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] && !visited[r][c]) {
                    int cnt = dfs(r, c);
                    if (cnt > max) max = cnt;
                }
            }
        }

        System.out.println(max);
    }

    public static int dfs(int r, int c) {
        visited[r][c] = true;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] && !visited[nr][nc]) {
                cnt += dfs(nr, nc);
            }
        }
        return cnt;
    }
}
