import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int startX, startY;
    static int count;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if(str.charAt(j) == 'I') {
                    startX = i;
                    startY = j;
                }
                map[i][j] = str.charAt(j);
            }

        }
        dfs(startX, startY);


        if(count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }

    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'P') {
            count++;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                continue;
            if(map[nx][ny] != 'X' && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
}


