import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
        static ArrayList<Integer>[] graph;
        static boolean[] visited;
        static int[] order;
        static int cnt = 1;

        public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                graph = new ArrayList[n+1];
                visited = new boolean[n+1];
                order = new int[n+1];

                for (int i = 1; i <= n; i++) {
                        graph[i] = new ArrayList<Integer>();
                }

                for (int i = 0; i < m; i++) {
                        st = new StringTokenizer(br.readLine());
                        int u = Integer.parseInt(st.nextToken());
                        int v = Integer.parseInt(st.nextToken());

                        graph[u].add(v);
                        graph[v].add(u);
                }

                for (int i = 1; i <= n; i++) {
                        Collections.sort(graph[i]);
                }

                dfs(r);

                for (int i = 1; i <= n; i++) {
                        System.out.println(order[i]);
                }

                br.close();
                
        }

        public static void dfs(int v) {
                visited[v] = true;
                order[v] = cnt++;
                
                for (int i = 0; i < graph[v].size(); i++) {
                        int next = graph[v].get(i);

                        if (!visited[next]) {
                                dfs(next);
                        }
                }
        }
}
