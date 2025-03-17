
import java.util.*;

public class Main {
    static char[][] map;
    static int r;
    static int c;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];

        int sX = 0;
        int sY = 0;

        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    sX = i;
                    sY = j;
                }
            }
        }

        int result = bfs(sX, sY);
        System.out.println( result == -1 ? "KAKTUS" :result);

    }

    public static int bfs(int sX, int sY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sX, sY});
        int[][] distance = new int[r][c];
        distance[sX][sY] = 1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    queue.offer(new int[]{i, j});

                }
            }
        }

        while (!queue.isEmpty()) {
            int[] move = queue.poll();
            char now = map[move[0]][move[1]];

            for (int i = 0; i < 4; i++) {
                int moveX = move[0] + dx[i];
                int moveY = move[1] + dy[i];

                if (0 > moveY || moveY >= c || 0 > moveX || moveX >= r) {
                    continue;
                }

                if (now == 'S') {
                    if (map[moveX][moveY] == 'D') {
                        return distance[move[0]][move[1]];
                    }
                    if (map[moveX][moveY] == '.') {
                        map[moveX][moveY] = 'S';
                        queue.offer(new int[]{moveX, moveY});
                        distance[moveX][moveY] = distance[move[0]][move[1]] + 1;
                    }
                }

                if (now == '*') {
                    if (map[moveX][moveY] == '.' || map[moveX][moveY] == 'S') {
                        map[moveX][moveY] = '*';
                        queue.offer(new int[]{moveX, moveY});
                    }
                }
            }
        }
        return -1;
    }
}
