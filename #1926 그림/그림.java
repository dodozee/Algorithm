import java.util.*;

public class Main {//박두지 화이팅!!
    static int[] dx = {-1, 0, 1, 0}; // 이동 방향 배열 (상, 우, 하, 좌)
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    static int cnt, max_area;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        cnt = 0;
        max_area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    int area = bfs(i, j);
                    max_area = Math.max(max_area, area);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max_area);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y});
        int area = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (paper[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                    area++;
                }
            }
        }

        return area;
    }
}
