import java.io.*;
import java.util.*;

/**
 * 투 포인터로 해결
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int ml = 0;
        int mr = 0;
        long min = Long.MAX_VALUE;

        while (left < right) {
            long sum = arr[left] + arr[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                ml = left;
                mr = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }

        }

            System.out.println(arr[ml] + " " + arr[mr]);
    }
}