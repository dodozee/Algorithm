import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    static int N, M;
    static int[][] map;
    static int[] rangeX = {0, 0, 1, -1};
    static int[] rangeY = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        int count = 0;

        while ((count = SeparateIceBerg()) < 2) {
            if (count == 0) {
                year = 0;
                break;
            }

            MeltIceBerg();
            year++;
        }

        bw.write(year + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int SeparateIceBerg(){
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        int dx, dy;

        for (int i = 0; i < 4; i++) {
            dx = x + rangeX[i];
            dy = y + rangeY[i];

            if(dx < 0 || dy < 0 || dx >= N || dy >= M)
                continue;

            if(map[dx][dy] != 0 && !visited[dx][dy]) {
                dfs(dx, dy, visited);
            }
        }
    }

    private static void MeltIceBerg(){
        Queue<IceBerg> queue = new LinkedList<>();

        boolean visited[][] = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    queue.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int dx, dy;
        while (!queue.isEmpty()) {
            IceBerg iceBerg = queue.poll();
            int seaNum = 0;

            for (int i = 0; i < 4; i++) {
                dx = iceBerg.x + rangeX[i];
                dy = iceBerg.y + rangeY[i];

                if(dx < 0 || dy < 0 || dx >= N || dy >= M)
                    continue;

                if(!visited[dx][dy] && map[dx][dy] == 0) {
                    seaNum++;
                }
            }

            if(map[iceBerg.x][iceBerg.y] - seaNum < 0)
                map[iceBerg.x][iceBerg.y] = 0;
            else
                map[iceBerg.x][iceBerg.y] -= seaNum;
        }
    }
}

class IceBerg {
    int x, y;

    public IceBerg(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
