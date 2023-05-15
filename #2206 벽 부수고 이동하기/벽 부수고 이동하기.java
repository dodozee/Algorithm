import java.io.*;
import java.util.*;


public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0, 1));
        visited[0][0][0] = true;

      
        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == 1 && cur.wall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new Point(nx, ny, 1, cur.dist + 1));
                } else if (map[nx][ny] == 0 && !visited[nx][ny][cur.wall]) {
                    visited[nx][ny][cur.wall] = true;
                    q.offer(new Point(nx, ny, cur.wall, cur.dist + 1));
                }
            }
        }

        return -1;
    }
}

class Point {
    int x, y, wall, dist;

    Point(int x, int y, int wall, int dist) {
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.dist = dist;
    }
}
