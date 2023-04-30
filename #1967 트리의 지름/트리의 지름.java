import java.util.*;
import java.io.*;

public class Main {//박두지 화이팅!!!
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max_weight = -1;
    static int max_idx = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
           st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        visited = new boolean[n+1];
        dfs(1, 0);

        visited = new boolean[n+1];
        dfs(max_idx, 0);

        System.out.println(max_weight);
    }

    static void dfs(int idx, int weight) {
        visited[idx] = true;
        if (weight > max_weight) {
            max_weight = weight;
            max_idx = idx;
        }

        for (Node node : tree[idx]) {
            if (!visited[node.to]) {
                dfs(node.to, weight + node.weight);
            }
        }
    }
}
class Node {
    int to, weight;
    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
