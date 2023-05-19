import java.util.*;

public class Main { //박두지 화이팅!!
    static int N, M;
    static int[][] space;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        space = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                space[i][j] = sc.nextInt();
            }
        }

        int maxDistance = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (space[i][j] == 0) {
                    int distance = calculateDistance(i, j);
                    maxDistance = Math.max(maxDistance, distance);
                }
            }
        }

        System.out.println(maxDistance);
    }

    static int calculateDistance(int x, int y) {
        int distance = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int j = 0; j < 8; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                        if (space[nx][ny] == 1) {
                            return distance;
                        }

                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return distance;
    }
}
