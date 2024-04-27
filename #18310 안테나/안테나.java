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

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (n % 2 == 0) {
            bw.write(arr[n/2-1] + "\n");//짝수일때 중간값 -> n/2-1 인덱스 이유는 배열은 0부터 시작하기 때문
        }else {
            bw.write(arr[n/2] + "\n");
        }
        
        bw.flush();
        bw.close();

    }
}