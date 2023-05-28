import java.util.*;
import java.io.*;

public class Main{//박두지 화이팅!!!
    static int R,C;
    static char[][] board;
    static boolean[] visited;
    static int maxCount = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[26]; // 알파벳 사용 여부 체크용

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(maxCount);

    }

    private static void dfs(int x, int y, int count) {
        visited[board[x][y]-'A'] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[board[nx][ny] - 'A']) {
                dfs(nx, ny, count + 1);
            }
        }

        visited[board[x][y] - 'A'] = false; // 백트래킹 : 알파벳 사용여부 초기화
        maxCount = Math.max(maxCount, count); // 최대 칸 수 갱신

    }
}