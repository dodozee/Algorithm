
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[][] copyMap;
    static Queue<Virus> q = new LinkedList<>();
    static int maxSafeArea = 0;
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeArea);
    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    private static void bfs(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.offer(new Virus(i, j));
                }
            }
        }

        copyMap = new int[N][M];//copyMap 초기화

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            Virus v = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.offer(new Virus(nx, ny));
                    }
                }
            }
        }
        calSafeArea(copyMap);
    }
    private static void calSafeArea(int[][] copyMap) {
        int safeArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }


}
class Virus{
    int x;
    int y;
    public Virus(int x, int y){
        this.x = x;
        this.y = y;
    }
}

