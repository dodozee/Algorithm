import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    static int N, X, answer;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
      
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0, right = N - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == X) {
                answer++;
                left++;
                right--;
            } else if (sum > X) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer);
    }
}
