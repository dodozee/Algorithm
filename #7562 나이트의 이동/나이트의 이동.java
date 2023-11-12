
import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    static int[] rangeX = {-1,-2,-2,-1,1,2,2,1};
    static int[] rangeY = {-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            Point[] points = new Point[2];

            for(int i =0; i<2 ; i++){
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                points[i] = new Point(start,end);
            }

            sb.append(BFS(arr, points, n) + "\n");

        }

        System.out.println(sb);


    }

    private static int BFS(int[][] arr, Point[] points, int n) {
        Queue<Point> q = new LinkedList<>();
        q.add(points[0]);

        boolean[][] visited = new boolean[n][n];
        visited[points[0].x][points[0].y] = true;

        while (!q.isEmpty()){
            Point p = q.poll();

            if(p.x == points[1].x && p.y == points[1].y){
                return p.count;
            }

            for(int i = 0; i< 8; i++) {
                int dx = p.x + rangeX[i];
                int dy = p.y + rangeY[i];

                if(dx<0 || dy<0 || dx>=n || dy>=n) continue;

                if(!visited[dx][dy]){
                    visited[dx][dy] = true;
                    q.add(new Point(dx,dy,p.count+1));
                }


            }
        }
        return -1;
    }

}

class Point{
    int x;
    int y;
    int count;

    Point(int x, int y){
        this.x = x;
        this.y =y;
        count = 0;
    }

    Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}