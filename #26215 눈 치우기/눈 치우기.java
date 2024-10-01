import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    private static final int LIMIT_MINUTE = 1440;
    private static final int ERROR = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = stoi.apply(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int remain = sum - max;// 나머지 시간
        int result = sum / 2; // 최대 시간의 절반

        if (sum % 2 != 0) {
            result++;
        }

        if (max > remain) {
            result = max;
        }

        if (result > LIMIT_MINUTE) {
            System.out.println(ERROR);
        }else{
            System.out.println(result);
        }
    }
}