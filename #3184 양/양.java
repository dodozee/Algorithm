import java.util.*;
import java.io.*;

public class Main {//박두지 화이팅!!!
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> sheepList, inSheepList;
    static List<int[]> wolfList, inWolfList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        sheepList = new ArrayList<>();
        wolfList = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'v' || map[i][j] == 'o') {
                    wolfList = new ArrayList<>();
                    sheepList = new ArrayList<>();
                    attack(i, j);
                    if (wolfList.size() < sheepList.size()) {
                        for (int[] wolf : wolfList) {
                            map[wolf[0]][wolf[1]] = '.';
                        }
                    } else {
                        for (int[] sheep : sheepList) {
                            map[sheep[0]][sheep[1]] = '.';
                        }
                    }
                }
            }
        }

        int wolfCnt = 0;
        int sheepCnt = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'v') wolfCnt++;
                else if (map[i][j] == 'o') sheepCnt++;
            }
        }

        System.out.println(sheepCnt + " " + wolfCnt);
    }

    private static void attack(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (map[cur[0]][cur[1]] == 'v') {
                wolfList.add(new int[]{cur[0], cur[1]});
            } else if (map[cur[0]][cur[1]] == 'o') {
                sheepList.add(new int[]{cur[0], cur[1]});
            }

            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if (0 <= ni && ni < R && 0 <= nj && nj < C) {
                    if (!visited[ni][nj] && map[ni][nj] != '#') {
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
        }
    }
}
