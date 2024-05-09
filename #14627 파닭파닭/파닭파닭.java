import java.io.*;
import java.util.*;

public class Main{
    
   static int S;
   static int C;
    
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    S = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    int start = 1;
    int end = 1000000000;
    long sum = 0;

    int[] fadak = new int[S];

    for (int i = 0; i < S; i++) {
      fadak[i] = Integer.parseInt(br.readLine());
      sum += fadak[i];
    }
    while (start <= end) {
      int mid = (start + end) / 2;

      int cnt = 0;
      for (int i = 0; i < S; i++) {
        cnt += fadak[i] / mid;
      }

      if (cnt >= C)
        start = mid + 1;
      else
        end = mid - 1;
    }

    System.out.println(sum - end * (long) C);

  }
}