import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, minTree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		minTree = new int[N * 4];

		minInit(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			sb.append(minFind(1, N, 1, left, right) + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int minInit(int start, int end, int node) {
		if (start == end) {
			return minTree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return minTree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
	}

	public static int minFind(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return Integer.MAX_VALUE;
		}

		if (left <= start && end <= right) {
			return minTree[node];
		}

		int mid = (start + end) / 2;

		return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
	}

}