import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        int[] arr = new int[n];
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); 
            int L = Integer.parseInt(st.nextToken()); 
            st = new StringTokenizer(br.readLine());
            if(P >= L){
                int[] subArr = new int[P];
                for(int j = 0 ; j < P; j++) subArr[j] = Integer.parseInt(st.nextToken());
                Arrays.sort(subArr);
                arr[i] = subArr[P - L];
            }else{
                arr[i] = 1;
            }
        }

        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length; i++){
          if(arr[i] > m) break;
          m -= arr[i];
          count++;
        }
        
        System.out.println(count);
    }
}