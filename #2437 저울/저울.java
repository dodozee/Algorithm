import java.io.*;
import java.util.*;

/**
  주어진 무게추를 이용하여 측정할 수 없는 무게가 최소 얼마부터인지 판단하는 문제
  * 주 포인트는 정렬된 상태의 수열집합에서 순차적으로 누적시키면서 더해준다.
    이전 누적합 + 1 보다 다음 원소가 크면 누적합 +1이 정답이다.  
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] weight = new int[N];

        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + 1 < weight[i]) {
                break;
            }

            sum += weight[i];
        }

        System.out.println(sum + 1);
    }
}