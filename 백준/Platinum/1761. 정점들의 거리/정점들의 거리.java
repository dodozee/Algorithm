import java.util.*;
import java.io.*;

class Main{
    static List<List<Node>> graph = new ArrayList<>();
    static int[][] parent;
    static int[] depth;
    static boolean[] check;
    static int[] distance;
    static int K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<=N;i++) graph.add(new ArrayList<>());

        for(int i=1;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(a,b,d));
            graph.get(b).add(new Node(b,a,d));
        }

        int root = 0;
        for(int i=1;i<=N;i++){
            check = new boolean[N+1];
            checkGraph(i);
            int cnt = 0;
            for(boolean isCheck : check) if(isCheck) cnt++;
            if(cnt == N){
                root = i;
                break;
            }
        }

        K = getK(N);
        check = new boolean[N+1];
        depth = new int[N+1];
        parent = new int[K+1][N+1];
        distance = new int[N+1];
        setDepth(root,0,0);

        for(int k=1;k<=K;k++){
            for(int n=1;n<=N;n++){
                parent[k][n] = parent[k-1][parent[k-1][n]];
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = depth[a]>depth[b] ? lca(b,a) : lca(a,b);
            sb.append(distance[a] + distance[b] - 2*distance[lca]).append("\n");
        }
        System.out.println(sb);
    }

    private static int lca(int a, int b){
        for(int k=K;k>=0;k--){
            if(Math.pow(2,k) <= depth[b] - depth[a]){
                if(depth[a] <= depth[parent[k][b]]) b = parent[k][b];
            }
        }

        for(int k=K;k>=0;k--){
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        return a!=b ? parent[0][a] : a;
    }

    private static void setDepth(int start, int cnt, int d){
        check[start] = true;
        depth[start] = cnt;
        distance[start] = d;

        List<Node> nextList = graph.get(start);
        for(Node next : nextList){
            if(!check[next.end]){
                parent[0][next.end] = start;
                setDepth(next.end, cnt+1, d+next.distance);
            }
        }
    }

    private static int getK(int N){
        int H = 0;
        int L = N;
        while(L>1){
            H++;
            L/=2;
        }
        return H;
    }

    private static void checkGraph(int start){
        check[start] = true;

        List<Node> nextList = graph.get(start);
        for(Node next : nextList){
            if(!check[next.end]) checkGraph(next.end);
        }
    }

    static class Node{
        int start;
        int end;
        int distance;

        Node(int start, int end, int distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}