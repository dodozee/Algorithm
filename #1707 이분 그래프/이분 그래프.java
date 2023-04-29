import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    static int k;
    static List<Integer>[] graph;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new List[v+1];
            colors = new int[v+1];
            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
                colors[i] = 0;
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            boolean isYesOrNo = true;
            for (int i = 1; i <= v; i++) {
                if (colors[i] == 0) {
                    isYesOrNo = isYesOrNo && bfs(i, 1);
                }
            }
            System.out.println(isYesOrNo ? "YES" : "NO");
        }
    }

    static boolean bfs(int start, int color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = color;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int nextColor = colors[cur] == 1 ? 2 : 1;
            for (int next : graph[cur]) {
                if (colors[next] == 0) {
                    q.add(next);
                    colors[next] = nextColor;
                } else if (colors[next] != nextColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
