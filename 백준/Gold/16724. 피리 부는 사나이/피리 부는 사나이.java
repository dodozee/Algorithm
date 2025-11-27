import java.util.Scanner;

public class Main {
   static int N, M;
   static char[][] map;
   static int[][] visited;
   static int SAFE_ZONE_COUNT = 0;

   static int[] dx = {-1, 1, 0, 0}; // U, D, L, R 
   static int[] dy = {0, 0, -1, 1};

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       N = sc.nextInt();
       M = sc.nextInt();
       sc.nextLine(); 

       map = new char[N][M];
       visited = new int[N][M];

       for (int i = 0; i < N; i++) {
           String line = sc.nextLine();
           for (int j = 0; j < M; j++) {
               map[i][j] = line.charAt(j);
               visited[i][j] = 0; 
           }
       }

       for (int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               if (visited[i][j] == 0) {
                   dfs(i, j);
               }
           }
       }

       System.out.println(SAFE_ZONE_COUNT);
   }

   static void dfs(int x, int y) {
       visited[x][y] = 1;  
       
       int nx = x + dx[getDirection(map[x][y])];
       int ny = y + dy[getDirection(map[x][y])];
       
       if (visited[nx][ny] == 0) {
           dfs(nx, ny);
       } 
       else if (visited[nx][ny] == 1) {
           SAFE_ZONE_COUNT++;
       }
       
       visited[x][y] = 2;  
   }

   static int getDirection(char c) {
       switch (c) {
           case 'U': return 0;
           case 'D': return 1;
           case 'L': return 2;
           case 'R': return 3;
       }
       return -1;
   }
}