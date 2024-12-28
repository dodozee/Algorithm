import java.io.*;
import java.util.*;
 
public class Main {
   public static int[][] paper = new int[101][101];
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
 
      for(int n=0;n<N;n++){
         StringTokenizer st = new StringTokenizer(in.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = 100-Integer.parseInt(st.nextToken());
 
         for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++){
               paper[y-i][x+j] = 1;
            }
         }
      }
      int cnt = 0;
      int[][] deltas = {{0,1},{1,0}};
      for(int i=0;i<=100;i++){
         for(int j=0;j<=100;j++){
 
            for(int d=0;d<2;d++){
               int ni = i+deltas[d][0];
               int nj = j+deltas[d][1];
 
               if(ni>=0 && ni<=100 && nj>=0 && nj<=100 && paper[i][j] != paper[ni][nj]) 
                   cnt++;
            }
 
         }
      }
 
      System.out.println(cnt);
   }
}