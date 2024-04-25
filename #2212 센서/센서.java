import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //센서의 갯수
        int k = Integer.parseInt(br.readLine()); //집중국의 갯수

        if (k >= n) {
            System.out.println(0);
            return;
        }
        int min_sum = 0;

        int[] sensors = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors); //센서들을 오름차순으로 정렬

        Integer[] diffArray = new Integer[n-1];

        for (int i = 0; i < n - 1; i++) {
            diffArray[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(diffArray, Collections.reverseOrder()); //센서들의 차이들을 내림차순으로 정렬

        for (int i = k - 1; i < n - 1; i++) { //센서들의 차이들 중 k-1개를 제외한 나머지들을 더한다.
            min_sum += diffArray[i];
        }

        System.out.println(min_sum);

    }
}