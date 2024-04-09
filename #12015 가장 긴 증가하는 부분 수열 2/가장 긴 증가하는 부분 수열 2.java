import java.io.*;
import java.util.*;
/**
 *
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] LIS = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {
            int key = arr[i];

            // LIS 배열의 마지막 값보다 key값이 크다면

            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            }else{
                //Lower Bound 방식으로 key값을 찾아서 변경
                int lo = 0;
                int hi = lengthOfLIS;
                
                while(lo < hi){
                    int mid = (lo + hi) / 2;
                    if (LIS[mid] < key) {
                        lo = mid + 1;
                    }else{
                        hi = mid;
                    }
                }
                LIS[hi] = key;
            }
        }
        
        System.out.println(lengthOfLIS);
    }
}