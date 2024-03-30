import java.io.*;
import java.util.*;

public class Main {

    static int l,r,c;
    static char[][][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0,0,0,0,1,-1};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {1,-1,0,0,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) break;


            int sx = 0;
            int sy = 0;
            int sz = 0;

            map = new char[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = str.charAt(k);
                        if (map[i][j][k] == 'S') {
                            sx = i;
                            sy = j;
                            sz = k;
                            map[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();
            }
            bfs(sx, sy, sz);
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y, int z) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[l][r][c];

        q.add(new int[] {x,y,z,0});
        visited[x][y][z] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];
            int cnt = cur[3];

            if(map[cx][cy][cz] == 'E') {
                sb.append("Escaped in ").append(cnt).append(" minute(s).\n");
                return;
            }

            for (int d = 0; d < 6; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nz = cz + dz[d];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c) continue;
                if(visited[nx][ny][nz] || map[nx][ny][nz] == '#') continue;

                q.add(new int[] {nx,ny,nz,cnt+1});
                visited[nx][ny][nz] = true;
            }
        }
        sb.append("Trapped!\n");
    }




}