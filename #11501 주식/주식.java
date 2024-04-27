

import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] num;

        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long ans = 0;
            st = new StringTokenizer(br.readLine());
            num = new int[n];

            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            int max = num[n - 1]; // 마지막 값이 최대값이라고 가정

            for (int j = n - 2; j >= 0; j--) {
                if (num[j] <= max) { // 현재 값이 최대값보다 작거나 같으면 최대값을 현재값으로 변경
                    ans += max - num[j]; // 최대값과 현재값의 차이만큼 더해줌
                }else{
                    max = num[j]; // 현재값이 최대값보다 크면 최대값을 현재값으로 변경
                }
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();

    }
}