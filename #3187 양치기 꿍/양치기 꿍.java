
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    static boolean[][] visited;
    static char[][] map;
    static int R;
    static int C;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int sheepResult = 0;
    static int wolfResult = 0;


    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(!visited[i][j] && map[i][j] != '#') {
                    bfs(new Point(i, j));
                }
            }
        }
        System.out.println(sheepResult + " " + wolfResult);
    }

    private static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        
        visited[point.x][point.y] = true;
        int sheep = 0;
        int wolf = 0;

        while (!queue.isEmpty()) {
            Point point2 = queue.poll();
            int x = point2.x;
            int y = point2.y;
            if (map[x][y] == 'k') {
                sheep++;
            } else if (map[x][y] == 'v') {
                wolf++;
            }

            for (int i = 0; i < 4; i++) {
                int x2 = point2.x + dx[i];
                int y2 = point2.y + dy[i];
                if((x2 > 0 && x2 < R && y2 > 0 && y2 < C) && !visited[x2][y2] && map[x2][y2] != '#') {
                    visited[x2][y2] = true;
                    queue.offer(new Point(x2, y2));
                }
            }
        }
        if(sheep > wolf){
            sheepResult += sheep;
        } else {
            wolfResult += wolf;
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}