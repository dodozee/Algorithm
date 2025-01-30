import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static boolean [][] visited;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();//버퍼 비우기

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[n][m];//방문 여부 초기화
                    int length = bfs(i,j);
                    max = Math.max(max, length);
                }
            }
        }
        System.out.println(max);



    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;

        int length = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];


                if(nx < 0 || ny < 0 || nx >=n || ny >= m) continue;
                if(visited[nx][ny] || map[nx][ny] == 'W') continue;

                q.offer(new Node(nx, ny, cur.cost + 1));
                length = Math.max(length, cur.cost + 1);
                visited[nx][ny] = true;
            }
        }
        return length;
    }
}

class Node{
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
