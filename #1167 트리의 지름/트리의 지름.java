import java.io.*;
import java.util.*;


public class Main{ //박두지 화이팅!!! //갓천대 화이팅!!!
    static int V;//정점의 개수
    static ArrayList<Node>[] graph; //그래프
    static boolean[] visited; //방문 여부
    static int longest; //가장 긴 정점
    static int longestDist; //가장 먼 거리


    static class Node{
        int v;// 연결된 정점
        int w;// 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();//그래프 초기화
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                graph[u].add(new Node(v, w)); //서로 양방향으로 연결
                graph[v].add(new Node(u, w));
            }
        }

        dfs(1, 0);
        visited = new boolean[V + 1];
        dfs(longest, 0);

        System.out.println(longestDist);

    }

    //깊이 우선 탐색으로 가장 노드간 가장 긴거리 찾기.
    private static void dfs(int v, int dist) {
        visited[v] = true;

        if (dist > longestDist) { //더 크면 갱신.
            longestDist = dist;
            longest = v;
        }

        for (Node next : graph[v]) {
            if (!visited[next.v]) {
                dfs(next.v, dist + next.w);
            }
        }
    }
}