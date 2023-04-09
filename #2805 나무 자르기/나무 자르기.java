import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine());

        int max=0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);

        }

        int left=0;
        int right=max;

        while (left <= right) {
            int mid = (left + right) / 2; //이분 탐색을 통해 절단기 높이 mid를 기준으로 각 나무를 절단했을때 가져갈수 있는 나무의 길이를 구한다.
            long sum =0;

            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= m) { //만약 필요한 나무보다 더 많이 잘랐으면 left를 줄인다.
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
