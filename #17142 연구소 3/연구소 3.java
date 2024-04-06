import java.io.*;
import java.util.*;

/**
 * 문제 : 인체에 치명적인 바이러스를 연구하던 연구소에 승원이가 침입했고, 바이러스를 유출하려고 한다. 바이러스는
 * 활성상태와 비활성 상태가 있다. 처음에는 모든 바이러스는 비활성 상태이고, 활성 상태인 바이러스는 상하좌우로
 * 인접한 모든 빈칸으로 동시에 복제가 되며, 1초가 걸린다. 승원이는 연구소의 바이러스 M개를 활성상태로 변경하려고 한다.
 * 연구소는 크기가 N×N인 정사각형으로 나타낼 수 있으며, 정사각형은 1×1 크기의 정사각형으로 나누어져 있다.
 * 연구소는 빈 칸, 벽, 바이러스로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 활성 바이러스가 비활성 바이러스가 있는
 * 칸으로가면 비활성 바이러스가 활성으로 변한다.
 * 예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자. 0은 빈 칸, 1은 벽, 2는 바이러스의 위치이다.
 * 백트레킹 + bfs

 */

public class Main {
    static int N, M, min, zeroCount; //zeroCount : 0의 개수
    static int[][] map, map_copy; //연구소, 연구소 복사본
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<Point> virus;
    static Point[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        map_copy = new int[N][N];
        output = new Point[M];
        min = Integer.MAX_VALUE;
        virus = new ArrayList<>();
        zeroCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) { //바이러스 위치라면 virus에 추가 및 map에는 -2로 기록
                    virus.add(new Point(i, j));
                    map[i][j] = -2;
                } else if (map[i][j] == 1) { //벽이라면 map에 -1로 기록
                    map[i][j] = -1;
                } else {
                    zeroCount++; //0의 개수 -> 빈칸의 갯수
                }
            }
        }

        combination(0, 0, virus.size(), M); //바이러스 M개를 뽑는 조합

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    private static void combination(int start, int depth, int n, int r) {
        if (depth == r) {
            bfs(); //bfs로 바이러스 퍼트리기
            return;
        }
        for (int i = start; i < n; i++) {
            output[depth] = virus.get(i);
            combination(i + 1, depth + 1, n, r);
        }
    }

    private static void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map_copy[i][j] = map[i][j]; //map 복사하는 이유 : 바이러스를 퍼트릴 때 원본 map을 계속 사용해야 하기 때문
            }
        }

        Queue<Point> q = new LinkedList<>();//virus 위치를 담을 큐
        boolean[][] visited = new boolean[N][N]; //방문 체크를 위한 배열


        //조합에서 뽑은 M개의 바이러스 위치를 큐에 넣어주고 방문 체크, map에는 0으로 바꿔줌
        for (int i = 0; i < M; i++) {

            q.offer(output[i]);
            map_copy[output[i].x][output[i].y] = 0;
            visited[output[i].x][output[i].y] = true;
        }

        int count = 0; //바이러스가 퍼진 개수

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N|| ny >= N) continue;

                if(visited[nx][ny]) {
                    continue;
                }

                if(map_copy[nx][ny] == -1) {

                    continue;
                }

                if (map_copy[nx][ny] != -2) {
                    count++;
                }

                map_copy[nx][ny] = map_copy[cur.x][cur.y] + 1; //바이러스가 퍼진 시간을 기록(이전보다 1초가 더 지났다는 의미)
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }

        //바이러스가 퍼진 후 0의 개수와 바이러스가 퍼진 개수가 같지 않다면 return

        if (count != zeroCount) {
            return;
        }
        for (int i = 0; i < virus.size(); i++) {
            map_copy[virus.get(i).x][virus.get(i).y] = 0;
        }

        //map에서 최대 시간 찾기

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, map_copy[i][j]);
            }
        }

        if(min > max) {
            min = max;
        }
    }
}

class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}