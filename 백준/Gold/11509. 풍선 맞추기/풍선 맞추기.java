
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, result = 0;
    private static int[] arr = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int H = Integer.parseInt(st.nextToken());
            if (arr[H] > 0) {
                // 화살 사용
                arr[H]--;
            }
            arr[H - 1]++;
        }
        
        for (int i : arr) {
            result += i;
        }
        System.out.println(result);
    }
}