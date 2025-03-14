import java.io.*;
import java.util.*;

public class Main {
	static LinkedList<Integer>[] adjList;
	public static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		adjList = new LinkedList[N+1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}

		dfs(1, 0, 0);
		
		System.out.println((answer % 2) == 0 ? "No" : "Yes");
		
	}

	public static void dfs(int cur, int p, int cnt) {
		for(int next : adjList[cur]) {
			if(next != p) {
				dfs(next, cur, cnt+1);
			}
		}
		
		if(adjList[cur].size() == 1) {
			answer += cnt;
		}
	}

}