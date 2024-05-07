import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
 
      int[] money = new int[N];
      int min = 1, max = 1;
 
      for(int i=0;i<N;i++) {
         money[i] = Integer.parseInt(br.readLine());
         min = Math.max(min,money[i]);
         max += money[i];
      }
 
      int mid;
      int count;
          int sum;
      while(min<=max){
         mid = (max + min)/2;
          
         count = 1;
 
         sum = 0;
 
         for(int i=0;i<N;i++){
            sum += money[i];
            if(sum>mid) {
               sum = money[i];
               count++;
            }
         }
         if(count>M) min = mid+1;
         else max = mid-1;
      }
 
      System.out.println(min);
   }
}