import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt(); // A의 힘
        int B = scanner.nextInt(); // B의 힘
        int N = scanner.nextInt(); // 동규의 현재 위치
        int M = scanner.nextInt(); // 주미의 현재 위치

        int[] dist = new int[100001]; // 각 돌까지의 최소 이동 횟수를 저장하는 배열
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == M) // 주미에게 도달한 경우
                break;

            int[] next = {curr - 1, curr + 1, curr - A, curr + A, curr - B, curr + B, curr * A, curr * B};

            for (int i = 0; i < 8; i++) {
                if (next[i] >= 0 && next[i] <= 100000 && dist[next[i]] == -1) {
                    dist[next[i]] = dist[curr] + 1;
                    queue.offer(next[i]);
                }
            }
        }

        System.out.println(dist[M]);

        scanner.close();
    }
}
