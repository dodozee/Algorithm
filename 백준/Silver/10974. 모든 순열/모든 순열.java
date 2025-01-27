
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] res, arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N]; 
		res = new int[N]; 
		visited = new boolean[N]; 

		for (int i = 1; i <= N; i++) {
			arr[i - 1] = i;
		}

		perm(0);
		System.out.println(sb);

	}

	static void perm(int depth) {

		if (depth == N) {

			for (int i : res) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) 
				continue;

			if (!visited[i]) {
				visited[i] = true;
				res[depth] = i + 1;
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}

}