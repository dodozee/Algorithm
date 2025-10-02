
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] A = input();
        int[] B = input();
        int n = A.length - 1;
        int m = B.length - 1;

        int idx_A = 1;
        int idx_B = 1;
        Queue<Integer> word = new ArrayDeque<>();

        while (idx_A <= n && idx_B <= m) {
            int result = 0;
            for (int i = idx_A; i <= n; i++) {
                for (int j = idx_B; j <= m; j++) {
                    if (A[i] == B[j]) result = Math.max(result, A[i]);
                }
            }

            if (result != 0) {
                word.offer(result);
                while (A[idx_A] != result) idx_A++;
                while (B[idx_B] != result) idx_B++;
                idx_A++;
                idx_B++;
            } else break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(word.size()).append("\n");
        while (!word.isEmpty()) sb.append(word.poll()).append(" ");
        bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

    private static int[] input() throws IOException {
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}