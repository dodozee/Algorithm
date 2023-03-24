
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
/* 박두지 화이팅! 갓천대 컴공 화이팅!
[문제 해석 및 풀이]
1.시작(1,1)과 끝(n,m)까지 bfs 알고리즘으로 최소 거리를 계산하는 문제이다.
2.distance에 이동할 때 마다 +1씩 시켜주면서 갱신한다.
3.bfs는 큐를 이용하여 구현한다.
 */
public class Main {

    static int n, m; // 미로의 크기
    static int[][] maze; // 미로 정보
    static int[][] distance; // 시작점으로부터의 거리
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 미로 정보 입력 받기
        maze = new int[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0'; // 문자열을 정수형으로 변환하여 미로 정보 배열에 저장
            }
        }

        bfs(0, 0); // 시작점에서부터 bfs 탐색 시작

        System.out.println(distance[n - 1][m - 1]); // 목적지까지의 최소 거리 출력
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y}); // 시작점 큐에 삽입
        distance[x][y] = 1; // 시작점으로부터의 거리를 1로 초기화

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 꺼내서 현재 위치로 설정

            for (int i = 0; i < 4; i++) { // 상하좌우로 이동
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // 미로 범위를 벗어나거나, 갈 수 없는 칸이거나, 이미 방문한 칸인 경우 continue
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maze[nx][ny] == 0 || distance[nx][ny] != 0) {
                    continue;
                }

                queue.offer(new int[]{nx, ny}); // 다음 칸을 큐에 삽입
                distance[nx][ny] = distance[current[0]][current[1]] + 1; // 다음 칸까지의 거리를 현재 칸까지의 거리 + 1로 갱신
            }
        }
    }
}

