import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      boolean[] light = new boolean[N+1];
      for(int i=0;i<B;i++) light[Integer.parseInt(in.readLine())] = true;
 
      int tmp = 0;
      for(int i=1;i<=K;i++) if(light[i]) tmp++;
 
      int min = tmp;
      for(int i=K+1;i<=N;i++){
         if(light[i-K]) tmp--;
         if(light[i]) tmp++;
 
         min = Math.min(min,tmp);
      }
 
      System.out.println(min);
   }
}