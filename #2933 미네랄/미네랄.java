import java.io.*;
import java.util.*;

public class Main { //박두지 화이팅!!!!

    static int R;
    static int C;
    static int N;
    static char[][] map;
    static int[][] clusters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        N = Integer.parseInt(br.readLine());
        inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int bar = Integer.parseInt(inputs[i]);

            destructMineral(bar, i % 2 == 0 ? 1 : 2);

            setCluster();
        }

        // print result
        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }
    }

    public static void destructMineral(int height, int direction) {
        int row = R - height;
        int col = direction == 1 ? 0 : C - 1;

        while (col >= 0 && col < C) {
            if (map[row][col] == 'x') {
                map[row][col] = '.';
                break;
            }
            col += direction == 1 ? 1 : -1;
        }
    }

    public static void setCluster() {
        clusters = new int[R][C];

        int clusterNum = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && clusters[i][j] == 0) {
                    if (findCluster(i, j, clusterNum)) {
                        return;
                    }
                    clusterNum++;
                }
            }
        }
    }

    public static boolean findCluster(int row, int col, int clusterNum) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int lowest = -1;

        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> cluster = new ArrayList<>();

        queue.add(new Point(row, col));
        clusters[row][col] = clusterNum;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            lowest = Math.max(lowest, current.row);

            for (int i = 0; i < 4; i++) {
                int newRow = current.row + dx[i];
                int newCol = current.col + dy[i];

                if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C) {
                    if (clusters[newRow][newCol] == 0 && map[newRow][newCol] == 'x') {
                        clusters[newRow][newCol] = clusterNum;
                        queue.add(new Point(newRow, newCol));
                    }
                }
            }

            cluster.add(current);
        }

        if (lowest != R - 1) {
            moveCluster(cluster);
            return true;
        }

        return false;
    }

    public static void moveCluster(ArrayList<Point> cluster) {
        int move = 1;

        for (Point point : cluster) {
            map[point.row][point.col] = '.';
        }

        outerLoop:
        while (true) {
            for (Point point : cluster) {
                int newRow = point.row + move;
                int newCol = point.col;

                if (newRow >= R || map[newRow][newCol] == 'x') {
                    move--;
                    break outerLoop;
                }
            }
            move++;
        }

        for (Point point : cluster) {
            map[point.row + move][point.col] = 'x';
        }
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
