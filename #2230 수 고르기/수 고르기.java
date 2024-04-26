import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 * 투 포인터
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;

        while(start < n ){
            if (arr[start] - arr[end] < m) {
                start++;
                continue;
            }

            if (arr[start] - arr[end] == m) {
                result = m;
                break;
            }

            result = Math.min(result, arr[start] - arr[end]);
            end++;
        }

        bw.write(result + "\n");
        bw.flush();


    }
}