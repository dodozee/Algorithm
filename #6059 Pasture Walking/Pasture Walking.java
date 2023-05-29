import java.io.*;
import java.util.*;

class Main {//박두지 화이팅!!!
    static int N, Q;
    static List<List<Edge>> graph;

    static class Edge {
        int destination;
        int length;

        public Edge(int destination, int length) {
            this.destination = destination;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 도보 정보 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            // 양방향 도보 추가
            graph.get(a).add(new Edge(b, l));
            graph.get(b).add(new Edge(a, l));
        }

        // 질문에 대한 답 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            int distance = getDistance(p1, p2);
            sb.append(distance).append("\n");
        }

        System.out.println(sb.toString());
    }

    // 두 목초지 사이의 거리 계산 (DFS)
    static int getDistance(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        int[] distances = new int[N + 1];

        dfs(start, 0, visited, distances);

        return distances[end];
    }

    static void dfs(int node, int distance, boolean[] visited, int[] distances) {
        visited[node] = true;
        distances[node] = distance;

        for (Edge edge : graph.get(node)) {
            if (!visited[edge.destination]) {
                dfs(edge.destination, distance + edge.length, visited, distances);
            }
        }
    }
}
