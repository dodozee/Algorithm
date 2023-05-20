import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {//박두지 화이팅!!!!
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(); // 격자의 행 개수
        int N = scanner.nextInt(); // 격자의 열 개수

        grid = new int[M][N]; // 격자 정보 저장을 위한 배열
        visited = new boolean[M][N]; // 방문 여부 저장을 위한 배열

        for (int i = 0; i < M; i++) {
            String row = scanner.next(); // 한 줄을 문자열로 입력 받음
            for (int j = 0; j < N; j++) {
                grid[i][j] = row.charAt(j) - '0'; // 문자열을 숫자로 변환하여 배열에 저장
            }
        }

        scanner.close();

        // 바깥쪽에서 전류를 흘려보낼 수 있는지 검사
        for (int i = 0; i < N; i++) {
            if (grid[0][i] == 0) { // 격자의 가장 위쪽 행에서 흰색 격자를 찾으면 전류 흘림
                if (bfs(0, i, M, N)) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

    // BFS를 이용하여 전류가 안쪽까지 침투되는지 검사
    public static boolean bfs(int startX, int startY, int M, int N) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 안쪽에 도착했을 경우 전류 침투 성공
            if (current.x == M - 1) {
                return true;
            }

            // 상하좌우로 이동하며 흰색 격자를 찾고 방문하지 않은 경우 큐에 추가
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && grid[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return false; // 전류가 안쪽까지 침투하지 못한 경우
    }

    // 좌표를 저장하기 위한 클래스
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
