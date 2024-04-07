import java.io.*;
import java.util.*;

/**
 *
 */

public class Main {
    static int N, M, R;
    static int count = 1;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        result[cur] = count++;
        Collections.sort(graph.get(cur), Collections.reverseOrder()); // 내림차순 정렬
        for(int value : graph.get(cur)){
            if(!visited[value]){
                dfs(value);
            }
        }

        return;
    }
}