import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int F = sc.nextInt(); // 건물의 전체 층 수
        int S = sc.nextInt(); // 강호가 현재 있는 층
        int G = sc.nextInt(); // 스타트링크가 있는 층
        int U = sc.nextInt(); // U층 위로 이동하는 버튼
        int D = sc.nextInt(); // D층 아래로 이동하는 버튼

        int[] dist = new int[F + 1]; // 건물의 모든 층에 대한 거리를 저장할 배열
        Arrays.fill(dist, -1); // 거리 값을 -1로 초기화 (방문하지 않은 층)
        dist[S] = 0; // 시작 층의 거리는 0

        Queue<Integer> q = new LinkedList<>(); // BFS 탐색을 위한 큐
        q.add(S); // 시작 층을 큐에 추가

        while (!q.isEmpty()) {
            int cur = q.poll(); // 현재 층

            // U버튼을 눌렀을 때 갈 수 있는 층
            int nextUp = cur + U;
            if (nextUp <= F && dist[nextUp] == -1) { // 건물을 벗어나지 않고 방문하지 않은 층일 때
                dist[nextUp] = dist[cur] + 1; // 거리 갱신
                q.add(nextUp); // 큐에 추가
            }

            // D버튼을 눌렀을 때 갈 수 있는 층
            int nextDown = cur - D;
            if (nextDown >= 1 && dist[nextDown] == -1) { // 건물을 벗어나지 않고 방문하지 않은 층일 때
                dist[nextDown] = dist[cur] + 1; // 거리 갱신
                q.add(nextDown); // 큐에 추가
            }
        }

        // 거리를 찾지 못한 경우 "use the stairs" 출력
        if (dist[G] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(dist[G]); // 거리 출력
        }
    }
}
