import java.util.*;

public class Main { //박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 유저의 수
        int M = sc.nextInt(); // 친구 관계의 수

        List<Integer>[] friends = new ArrayList[N + 1]; // 유저들의 친구 관계를 저장할 리스트 배열
        int[] baconNumbers = new int[N + 1]; // 케빈 베이컨의 수를 저장할 배열

        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends[a].add(b);
            friends[b].add(a);
        }

        // 케빈 베이컨의 수를 계산하는 함수
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int current = queue.poll();
                    baconNumbers[i] += level; // 현재 유저의 케빈 베이컨의 수에 누적
                    for (int friend : friends[current]) {
                        if (!visited[friend]) {
                            queue.offer(friend);
                            visited[friend] = true;
                        }
                    }
                }
                level++;
            }
        }

        // 케빈 베이컨의 수가 가장 작은 사람을 찾는 과정
        int minBaconNumber = Integer.MAX_VALUE;
        int minPerson = 0;
        for (int i = 1; i <= N; i++) {
            if (baconNumbers[i] < minBaconNumber) {
                minBaconNumber = baconNumbers[i];
                minPerson = i;
            }
        }

        System.out.println(minPerson);
    }
}
