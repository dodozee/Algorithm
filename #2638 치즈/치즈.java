import java.io.*;
import java.util.*;

public class Main {//dfs로 문제품
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;// 0: 빈칸, 1: 치즈, 2: 외부공기
    static boolean[][] visited;
    static ArrayList<Point> cheeseList;

    static int cheeseCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheeseList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseList.add(new Point(i, j));
                    cheeseCount++;
                }
            }
        }

        int time = 0;

        while (cheeseCount != 0) {
            time ++;
            visited = new boolean[N][M];
            dfs(0, 0);
            melting();
        }

        System.out.println(time);

    }
    //외부공기를 찾기 위한 dfs -> 2로 바꿔줌
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = 2; //외부 공기라는 의미로 2로 바꿔줌

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;
            if(visited[nx][ny] || map[nx][ny] == 1) // 치즈거나 내부라도 pass
                continue;

            dfs(nx, ny);

        }

    }

    private static void melting() {
        for (int i = 0; i < cheeseList.size(); i++) {
            Point p = cheeseList.get(i);
            int x = p.x;
            int y = p.y;

            int count = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j]; // 상하좌우
                int ny = y + dy[j]; // 상하좌우

                if (map[nx][ny] == 2) {
                    count++; // 외부공기와 맞닿은 면의 개수 카운트
                }
            }

            if (count >= 2) { // 2면 이상이 외부공기와 맞닿아있으면
                map[x][y] = 0; // 녹이기
                cheeseCount--;
                cheeseList.remove(i);
                i--; // 삭제 후 인덱스 조정
            }
        }
    }


}

class Point{
    int x,y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;

    }
}
