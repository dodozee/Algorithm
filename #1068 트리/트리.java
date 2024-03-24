import java.io.*;
import java.util.*;

public class Main { //park doogee fighting!!!
    static int N, delete;
    static int[] parent;
    static int cnt ;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        parent = new int[N];
        int root = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
                root = i;
            }
        }
        st = new StringTokenizer(br.readLine());
        delete = Integer.parseInt(st.nextToken());

        deleteNode(delete);
        cnt = 0;
        visited = new boolean[N];
        countLeaf(root);
        System.out.println(cnt);

        }

    private static void deleteNode(int delete) {
        parent[delete] = -2;
        for (int i = 0; i < N; i++) {
            if (parent[i] == delete) {
                deleteNode(i);
            }
        }
    }

    private static void countLeaf(int node) {
        boolean isLeaf = true;
        visited[node] = true;
        if(parent[node] != -2) {
            for (int i = 0; i < N; i++) {
                if (parent[i] == node && !visited[i]) {
                    isLeaf = false;
                    countLeaf(i);
                }
            }
            if (isLeaf) {
                cnt++;
            }
        }

    }


}