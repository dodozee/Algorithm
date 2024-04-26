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

        int[][] arr = new int[t][2];

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i][0] = d;
            arr[i][1] = p;
        }

        Arrays.sort(arr, ((o1,o2) -> o2[1] - o1[1])); // 내림차순 정렬

        boolean[] check = new boolean[1001];

        int point = 0;

        for (int i = 0; i < t; i++) {
            int d = arr[i][0];
            int w = arr[i][1];
            for (int j = d; j > 0; j--) {
                if (!check[j]) {
                    check[j] = true;

                    point += w;
                    break;
                }
            }
        }

        bw.write(point + "\n");
        bw.flush();
    }
}