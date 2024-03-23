import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge>{
    int start, end, weight;
    Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o){   // 오름차순
        return this.weight - o.weight;
    }
}
public class Main {
    static int[] parent;
    static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        edgeList  = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(start, end, weight)); // 간선 정보 저장

        }

        parent = new int[N+1];

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        Collections.sort(edgeList); // 오름차순 정렬

        int answer = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if(!(find(edge.start)  == find(edge.end))){
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.println(answer);
    }

    private static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            parent[y] = x;
        }
    }
}