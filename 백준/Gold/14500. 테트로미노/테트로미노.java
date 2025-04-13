import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int R, C;
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for(int r = 0 ; r < R ; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                map[r][c] = Integer.parseInt(st2.nextToken());
            }
        }
        

        for(int r = 0 ; r < R ; r++) {
            for(int c = 0 ; c < C ; c++) {
                visited[r][c] = true; 
                backTracking(r, c, 1, map[r][c]);
                visited[r][c] = false;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    static void backTracking(int r, int c, int depth, int sum) { 

        if(depth == 4) {
            if(answer < sum) answer = sum;
            return;
        }

        for(int i = 0 ; i < 4 ; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(!isValid(nextR, nextC)) continue; 
            if(visited[nextR][nextC]) continue;



            if(depth == 2) {
                visited[nextR][nextC] = true;
                backTracking(r, c, depth+1, sum + map[nextR][nextC]);
                visited[nextR][nextC] = false;
            }

            visited[nextR][nextC] = true;
            backTracking(nextR, nextC, depth+1, sum + map[nextR][nextC]);
            visited[nextR][nextC] = false;
        }
    }

    static boolean isValid(int r, int c) { 
        if(r < 0 || r >= R || c < 0 || c >= C) return false;
        return true;
    }

}