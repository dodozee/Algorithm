import java.io.*;
import java.util.*;


/**
 * dp
 * 트리와 쿼리
 */
public class Main {
    static ArrayList<Integer>[] list; //용도 : 입력받은 트리
    static ArrayList<Integer>[] tree; //용도 : 트리
    static int[] parent;
    static int[] dp;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        size = new int[N + 1];
        dp = new int[N + 1];
        list = new ArrayList[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        makeTree(R, -1);
        countSubTreeNode(R);

        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(size[query]);
        }

    }

    private static void makeTree(int currentNode, int p) {
        for(int node : list[currentNode]){
            if(node == p) continue;
            tree[currentNode].add(node);//트리에 추가
            parent[node] = currentNode;//부모노드 저장
            makeTree(node, currentNode);//재귀
        }
    }

    private static void countSubTreeNode(int currentNode) {
        size[currentNode] = 1;//최소 자기 자신

        for (int node : tree[currentNode]) {
            countSubTreeNode(node);
            size[currentNode] += size[node];//자식노드의 개수를 더해줌
        }
    }


}