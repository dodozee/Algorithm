
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i < n; i++) {
            tree[input[i]].add(i);

        }
        System.out.println(dfs(0));

    }
    private static int dfs(int cur){
        int cnt = 0;
        int max = 0;

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        for (Integer next : tree[cur]) {
            dp[next] = dfs(next);
            q.add(new int[]{next, dp[next]});
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            cnt++;
            max = Math.max(max, node[1] + cnt);
        }
        return max;
    }
}


