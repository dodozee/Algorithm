import java.io.*;
import java.util.*;

import static java.util.Arrays.stream;

/**
 * 이분탐색
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//출력

        int N, num[], sum[], count =0;

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        sum = new int[N * N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum[count++] = num[i] + num[j];
            }
        }

        Arrays.sort(sum, 0, count-1);

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (Arrays.binarySearch(sum, 0, count - 1, num[i] - num[j]) < 0) {
                    continue;
                }
                bw.write(String.valueOf(num[i]));
                bw.flush();
                return;
            }
        }
    }
}