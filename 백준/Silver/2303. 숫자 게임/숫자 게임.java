import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[5];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;

            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        max = Math.max(max, (num[j] + num[k] + num[l]) % 10);
                    }
                }
            }
            result[i] = max;
        }

        int winner = -1, maxNum = -1;
        for (int i = 0; i < n; i++) {
            if (maxNum <= result[i]) {
                maxNum = result[i];
                winner = i + 1;
            }
        }
        System.out.println(winner);
    }
}