import java.io.*;
import java.util.*;


/**
 * dp
 * 트리와 쿼리
 */
public class Main {
    static ArrayList<Integer>[] list; //용도 : 입력받은 트리
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        dp = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);

        }

        dfs(R);
        StringBuffer sb = new StringBuffer();

        while (Q--> 0) {
            int query = Integer.parseInt(br.readLine());

            sb.append(dp[query] + "\n");
        }

        System.out.println(sb.toString());
    }

    private static int dfs(int now) {
        if (dp[now] != 0) {
            return dp[now];
        }

        visited[now] = true;
        int count = 1;

        for(int node : list[now]){
            if (!visited[node]) {
                count += dfs(node);
            }
            dp[now] = count;

        }

        return dp[now];
    }
}