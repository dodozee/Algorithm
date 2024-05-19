import java.io.*;
import java.util.*;


/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int [8][2];
        int[] result = new int[5];
        int answer = 0;

        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);


        for (int i = 0; i < 5; i++) {
            answer += arr[i][0];
            result[i] = arr[i][1] + 1;
        }

        Arrays.sort(result);

        System.out.println(answer);
        for (int i = 0; i < 5; i++) {
            System.out.print(result[i] + " ");
        }
    }

}