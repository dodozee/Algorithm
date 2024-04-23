import java.io.*;
import java.util.*;


/**
 *
 */
public class Main {
    static int n;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;

        dfs(1, 2, 0);

        bw.write(ans + "\n");
        bw.flush();
    }

    private static void dfs(int x, int y, int dir) {
        if (x == n && y == n) {
            ans++;
            return;
        }

        switch (dir) {
            case 0:
                if (y + 1 <= n && map[x][y + 1] == 0) {
                    dfs(x, y + 1, 0);
                }
                break;
            case 1:
                if (x + 1 <= n && map[x + 1][y] == 0) {
                    dfs(x + 1, y, 1);
                }
                break;
            case 2:
                if (y + 1 <= n && map[x][y+1] == 0) {
                    dfs(x, y+1, 0);

                }

                if (x + 1 <= n && map[x + 1][y] == 0) { // 남쪽

                    dfs(x + 1, y, 1);
                }


                break;

        }
        if (y + 1 <= n && x + 1 <= n && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {

            dfs(x + 1, y + 1, 2);
        }


    }

}