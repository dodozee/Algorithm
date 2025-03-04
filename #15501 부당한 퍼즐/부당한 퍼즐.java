import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
      int[] input = new int[N];
      StringTokenizer st = new StringTokenizer(in.readLine());
      for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
      int[] output = new int[N];
      st = new StringTokenizer(in.readLine());
      for(int i=0;i<N;i++) output[i] = Integer.parseInt(st.nextToken());
 
      boolean f = true,r = true;
      for(int idx=0;idx<N;idx++){
         if(input[0] != output[idx]) continue;
 
         for(int i=0;i<N;i++){
            if(input[i]==output[(idx+i)%N]) continue;
            f = false;
            break;
         }
 
         for(int i=0;i<N;i++){
            if(input[i] == output[(idx+N-i)%N]) continue;
            r = false;
            break;
         }
 
         if(f||r) System.out.println("good puzzle");
         else System.out.println("bad puzzle");
 
         return;
      }
   }
}