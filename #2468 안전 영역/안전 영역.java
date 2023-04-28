import java.io.*;
import java.util.*;

class Main{ //박두지 화이팅!! 불가능한 일도 가능하게 한다.

    static int n;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        int max = 0; //안전 영역의 최대 개수
        int minH = 101; //최소 높이
        int maxH = 0; //최대 높ㅇ

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] < minH) {
                    minH = map[i][j];
                }

                if (map[i][j] > maxH) {
                    maxH = map[i][j];
                }
            }
        }

        for (int h = minH - 1; h <= maxH; h++) { //높이에 따라 안 영역의 개수 구하기
            int cnt = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > h && !visited[i][j]) {// 해당 높이보다 높은 지점이면서 방문하지 않은 지점일 때
                    cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <0|| nx>=n || ny<0|| ny>=n) continue;
            if(map[nx][ny] <=h || visited[nx][ny]) continue;
            dfs(nx, ny, h);
        }
    }
}