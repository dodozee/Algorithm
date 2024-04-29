import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {
    static int[] num;
    static int N;
    static int SUM;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        SUM = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (SUM == 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == SUM) { // 합이 같으면
                result++;
            }
            return;
        }

        dfs(depth + 1, sum + num[depth]); // 현재 인덱스의 값을 더하는 경우
        dfs(depth + 1, sum); // 현재 인덱스의 값을 더하지 않는 경우
    }

}