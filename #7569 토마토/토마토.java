import java.io.*;
import java.util.*;

class TomatoLocation {//박두지 화이팅!!!
    int height;
    int row;
    int col;

    public TomatoLocation(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[] rowArray = {-1, 0, 1, 0, 0, 0};
    static int[] colArray = {0, 1, 0, -1, 0, 0};
    static int[] heightArray = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int[][][] tomatoBox;
    static Queue<TomatoLocation> tomatoQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());

        tomatoBox = new int[h + 1][n + 1][m + 1];

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int k = 1; k <= m; k++) {
                    tomatoBox[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    if (tomatoBox[i][j][k] == 1) tomatoQueue.add(new TomatoLocation(i, j, k));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!tomatoQueue.isEmpty()) {
            TomatoLocation tomatoLocation = tomatoQueue.poll();

            int height = tomatoLocation.height;
            int row = tomatoLocation.row;
            int col = tomatoLocation.col;

            for (int i = 0; i < 6; i++) {
                int moveHeight = height + heightArray[i];
                int moveRow = row + rowArray[i];
                int moveCol = col + colArray[i];

                if (isValidLocation(moveHeight, moveRow, moveCol)) {
                    tomatoQueue.add(new TomatoLocation(moveHeight, moveRow, moveCol));
                    tomatoBox[moveHeight][moveRow][moveCol] = tomatoBox[height][row][col] + 1;
                }
            }
        }

        int maxDays = Integer.MIN_VALUE;

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (tomatoBox[i][j][k] == 0) return -1;
                    maxDays = Math.max(maxDays, tomatoBox[i][j][k]);
                }
            }
        }

        if (maxDays == 1) return 0;
        else return (maxDays - 1);
    }

    private static boolean isValidLocation(int height, int row, int col) {
        return height >= 1 && height <= h && row >= 1 && row <= n && col >= 1 && col <= m && tomatoBox[height][row][col] == 0;
    }
}
