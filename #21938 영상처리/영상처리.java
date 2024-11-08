import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    static int[][] display;
    static boolean[][] visited;
    static int T, N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        display = new int[N][M];
        visited = new boolean[N][M];

        double sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                display[i][j] = (int) Math.floor(sum / 3);
                sum = 0;
            }
        }

        T = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(dfs(i,j))
                    count++;
            }
        }
        System.out.println(count);
    }

    private static boolean dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || display[x][y] < T) {
            return false;
        }

        if (display[x][y] >= T) {
            visited[x][y] = true;
            for(int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
            return true;
        }
        return false;
    }
}