import java.io.*;
import java.io.*;
import java.util.*;
import java.util.*;


public class Main {
    static long answer = 0;
    static int n;
    static ArrayList<Edge>[] edges;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n+1];
        v = new boolean[n+1];
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
        for (int i = 1; i <= n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        v[1] = true;
        dfs(1, 0);
        System.out.println(answer);
    }
        private static void dfs(int cur, long dist) {
        if (answer < dist)
            answer = dist;

        for (Edge next : edges[cur]) {
            if (v[next.to]) continue;
            v[next.to] = true;
            dfs(next.to, dist+next.c);
        }
    }

}
class Edge {
    int to, c;
    public Edge(int to, int c) {
        this.to = to;
        this.c = c;
    }
}