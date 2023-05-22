import java.util.Scanner;

public class Main {//박두지 화이팅~~~
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 수

        for (int t = 0; t < T; t++) {
            int H = scanner.nextInt(); // 그리드의 높이
            int W = scanner.nextInt(); // 그리드의 너비
            scanner.nextLine(); // 개행 문자 제거

            char[][] grid = new char[H][W]; // 그리드 배열

            // 그리드 입력 받기
            for (int i = 0; i < H; i++) {
                String row = scanner.nextLine();
                for (int j = 0; j < W; j++) {
                    grid[i][j] = row.charAt(j);
                }
            }

            int count = 0; // 양 무리의 개수

            // 그리드 순회하여 양 무리 개수 세기
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] == '#') {
                        count++;
                        dfs(grid, i, j); // 깊이 우선 탐색으로 인접한 양들을 찾아 무리로 처리
                    }
                }
            }

            System.out.println(count);
        }
    }

    // 깊이 우선 탐색 (DFS)
    private static void dfs(char[][] grid, int row, int col) {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
        int[] dy = {0, 0, -1, 1};

        grid[row][col] = '.'; // 방문한 위치는 풀로 표시하여 중복 탐색을 방지

        // 상하좌우 인접한 위치를 확인하여 양인 경우 재귀 호출
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (isValid(grid, newRow, newCol) && grid[newRow][newCol] == '#') {
                dfs(grid, newRow, newCol);
            }
        }
    }

    // 좌표가 그리드 범위 내에 있는지 확인하는 메소드
    private static boolean isValid(char[][] grid, int row, int col) {
        int H = grid.length;
        int W = grid[0].length;
        return row >= 0 && row < H && col >= 0 && col < W;
    }
}
