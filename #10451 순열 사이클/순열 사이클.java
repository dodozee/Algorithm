import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // 순열의 크기
            int[] permutation = new int[N + 1]; // 순열 배열

            for (int i = 1; i <= N; i++) {
                permutation[i] = scanner.nextInt();
            }

            boolean[] visited = new boolean[N + 1];
            int cycleCount = 0;

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i, permutation, visited);
                    cycleCount++;
                }
            }

            System.out.println(cycleCount);
        }
    }

    private static void dfs(int start, int[] permutation, boolean[] visited) {
        visited[start] = true;
        int next = permutation[start];

        if (!visited[next]) {
            dfs(next, permutation, visited);
        }
    }
}
