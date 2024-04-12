import java.io.*;
import java.util.*;


/**
 * dp
 * 얼리 아답터 : 어떤 새로운 아이디어를 먼저 받아들인 사람을 일컫는다.
 * 얼리 아답터가 아닌 사람들은 "자신의 주변의 모든 친구들이 얼리아답터일 때만" 새로운 아이디어를 받아들인다.
 *
 * 결국 어떤 아이디어를 SNS 상에서 전파하고자 할 때, "최소한의 얼리 아답터를 확보"하여 모든 사람에게 전파하는 것이 목표이다.
 *
 * 조건 : 모든 두 정점 사이에 이들은 잇는 경로가 존재는 하지만 사이클은 존재하지 않는 경우만 고려한다.
 */
public class Main {
    static int n;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();//인접리스트 초기화
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));


    }

    private static void dfs(int i) {
        visited[i] = true;
        dp[i][0] = 0; // i가 얼리 아답터가 아닌 경우
        dp[i][1] = 1; // i가 얼리 아답터인 경우

        for (int child : graph[i]) {
            if (!visited[child]) {
                dfs(child);
                dp[i][0] += dp[child][1]; // i가 얼리 아답터가 아닌 경우, 자식은 얼리 아답터여야 한다.
                dp[i][1] += Math.min(dp[child][0], dp[child][1]); // i가 얼리 아답터인 경우, 자식은 얼리 아답터일 수도 있고 아닐 수도 있다.
            }
        }
    }
}