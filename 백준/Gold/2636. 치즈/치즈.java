
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] board;
    static int n;
    static int m;
    static int cheese;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        m = s.nextInt();

        board = new int[n][m];
        cheese = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = s.nextInt();
                if (board[i][j] == 1) {
                    cheese++;
                }
            }
        }
        
        int cheeseCnt = 0;
        int time = 0;

        while (cheese != 0) {
            cheeseCnt = cheese;
            time++;
            visited = new boolean[n][m];
            bfs();
        }

        System.out.println(time);
        System.out.println(cheeseCnt);
        
    }
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    if (board[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                    } else {
                        cheese--;
                        board[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
