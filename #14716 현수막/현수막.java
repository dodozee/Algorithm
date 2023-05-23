import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{ //박두지 화이팅@@!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0; //글자 개수 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        System.out.println(count);

    }

    static void dfs(int[][] grid, int row, int col) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != 1) {
            return;
        }

        grid[row][col] =-1; //방문한 곳 표ㅇ

        for(int i=0; i<4;i++){
            for(int j=0; j<4; j++){
                dfs(grid, row + dx[i], col + dy[j]);

            }
        }
    }
}