
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    static int T;
    static List<Integer> [] list;
    static int[] parent, depth;


    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            parent = new int[n + 1];
            depth = new int[n + 1];
            list = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            boolean[] rootCheck = new boolean[n + 1];
            Arrays.fill(rootCheck, true);
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                rootCheck[b] = false;
            }
            int rootIndex = 0;

            for (int i = 1; i < n + 1; i++) {
                if (rootCheck[i]) {
                    rootIndex = i;
                    break;
                }
            }

            init(rootIndex, 1, 0);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a, b));
        }

    }

    static void init(int cur, int h, int pa) {
        depth[cur] = h;
        parent[cur] = pa;
        for (int next : list[cur]) {
            if (next != pa) {
                init(next, h + 1, cur);
            }
        }
    }

    static int lca(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];
        while (ah > bh) {
            a = parent[a];
            ah--;
        }

        while (bh > ah) {
            b = parent[b];
            bh--;
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}