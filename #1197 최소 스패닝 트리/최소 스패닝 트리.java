import java.io.*;
import java.util.*;

public class Main {// 박두지 화이팅
    static int total;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq.add(new Node(from, to, value));
        }

        int size = pq.size();
        int total = 0;

        for (int i = 0; i < size; i++) {
            Node node = pq.poll();
            int from = node.from;
            int to = node.to;

            if(!isSameParent(to, from)){
                total += node.value;
                unionParent(node.to, node.from);
            }
        }
        System.out.println(total);
    }

    private static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if(x!= y){
            parent[y] = x;
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        return x == y;
    }
}

class Node implements Comparable<Node>{
    int to;
    int from;
    int value;

    Node(int to, int from, int value) {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}