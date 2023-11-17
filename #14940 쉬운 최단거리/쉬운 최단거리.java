import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int[][] map, distance;
    private static int M, N;
    private static boolean[][] isVisited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        boolean isCheckedStartPoint = false;
        String[] size = reader.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        int startX = -1, startY = -1;
        
        map = new int[N][M];
        distance = new int[N][M];
        isVisited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!isCheckedStartPoint) 
                for (int j = 0; j < M; j++) 
                    if (map[i][j] == 2) {
                        isCheckedStartPoint = true;
                        startX = i;
                        startY = j;
                        break;
                    }
        }
        bfs(startX, startY);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) 
                if (!isVisited[i][j] && map[i][j] == 1)
                    builder.append(-1 + " ");
                else 
                    builder.append(distance[i][j] + " ");
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }
    
    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];
                
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (map[nextX][nextY] == 0) continue;
                if (isVisited[nextX][nextY]) continue;

                queue.add(new Point(nextX, nextY));
                distance[nextX][nextY] = distance[current.x][current.y] + 1;
                isVisited[nextX][nextY] = true;
            }
        }
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}