import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 헛간의 개수
        int M = scanner.nextInt(); // 길의 개수

        List<List<Integer>> graph = new ArrayList<>(N + 1); // 그래프 생성
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            graph.get(A).add(B); // 양방향 길 추가
            graph.get(B).add(A);
        }

        scanner.close();

        int[] distances = bfs(graph, 1, N); // 1번 헛간에서부터 각 헛간까지의 최단 거리 계산

        int hideout = 0; // 숨을 헛간 번호
        int maxDistance = 0; // 최대 거리

        for (int i = 1; i <= N; i++) {
            if (distances[i] > maxDistance) {
                hideout = i;
                maxDistance = distances[i];
            }
        }

        int count = 0; // 최대 거리를 갖는 헛간의 개수

        for (int i = 1; i <= N; i++) {
            if (distances[i] == maxDistance) {
                count++;
            }
        }

        System.out.println(hideout + " " + maxDistance + " " + count);
    }

    public static int[] bfs(List<List<Integer>> graph, int start, int N) {
        int[] distances = new int[N + 1]; // 시작 정점으로부터의 거리 저장 배열
        boolean[] visited = new boolean[N + 1]; // 정점 방문 여부 배열

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    distances[next] = distances[current] + 1;
                }
            }
        }

        return distances;
    }
}
