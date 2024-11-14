import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(dfs(board, r, c, 0, 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean dfs(int[][] board, int r, int c, int eat, int moves) {
        if (r < 0 || r >= 5 || c < 0 || c >= 5 || board[r][c] == -1 || moves > 3) {
            return false;
        }

        if (board[r][c] == 1) {
            eat++;
        }

        if (eat >= 2) {
            return true;
        }

        int temp = board[r][c];
        board[r][c] = -1;

        boolean result = dfs(board, r + 1, c, eat, moves + 1) ||
                dfs(board, r - 1, c, eat, moves + 1) ||
                dfs(board, r, c + 1, eat, moves + 1) ||
                dfs(board, r, c - 1, eat, moves + 1);

        board[r][c] = temp;

        return result;
    }
}