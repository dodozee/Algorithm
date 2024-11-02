import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N;
    public static String string;
    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for (int i = 0; i < N; i++) {
            string = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = string.charAt(j);
            }
        }

        int normalCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    normalCount++;
                }
            }
        }

        int abnormalCount = 0;
        visited = new boolean[N+1][N+1];//방문 배열 재초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G';//적록색약인 경우 R과 G를 같은 색으로 인식
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    dfs(i, j);
                    abnormalCount++;
                }
            }
        }


        System.out.println(normalCount + " " + abnormalCount);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char tmp_char = arr[x][y];//현재 위치의 문자를 저장
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if(new_x < 0 || new_y < 0 || new_x >= N || new_y >= N) continue;

            if (!visited[new_x][new_y] && arr[new_x][new_y] == tmp_char) {//방문하지 않았고, 같은 문자라면
                dfs(new_x, new_y);

            }
        }

    }
}


