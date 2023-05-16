import java.util.Scanner;

public class Main {//박두지 화이팅!!!
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                int n = scanner.nextInt(); // 게임 구역의 크기
                int[][] gameMap = new int[n][n]; // 게임판의 구역(맵)

                // 게임판 입력 받기
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                gameMap[i][j] = scanner.nextInt();
                        }
                }

                // 도달 가능한지 확인
                boolean[][] visited = new boolean[n][n]; // 방문 여부를 저장하는 배열
                boolean result = canReachEnd(gameMap, visited, 0, 0); // 출발점은 (0, 0)

                // 결과 출력
                if (result) {
                        System.out.println("HaruHaru");
                } else {
                        System.out.println("Hing");
                }

                scanner.close();
        }

        // DFS를 통해 도달 가능한지 확인하는 함수
        public static boolean canReachEnd(int[][] gameMap, boolean[][] visited, int row, int col) {
                int n = gameMap.length;

                // 게임 구역을 벗어나거나 이미 방문한 경우
                if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col]) {
                        return false;
                }

                // 승리 지점에 도달한 경우
                if (gameMap[row][col] == -1) {
                        return true;
                }

                visited[row][col] = true; // 현재 위치를 방문 처리

                int jumpSize = gameMap[row][col]; // 현재 위치에서의 점프 크기

                // 오른쪽으로 이동
                if (canReachEnd(gameMap, visited, row, col + jumpSize)) {
                        return true;
                }

                // 아래로 이동
                if (canReachEnd(gameMap, visited, row + jumpSize, col)) {
                        return true;
                }

                visited[row][col] = false; // 방문 처리 해제 (백트래킹)

                return false;
        }
}
