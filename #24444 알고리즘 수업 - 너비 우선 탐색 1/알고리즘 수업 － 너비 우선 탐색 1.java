import java.io.*;
import java.util.*;

/**
 *
 */

public class Main {
    static int N, M, R;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b); //무방향 = 양방향
            list.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            var pos = list.get(i);
            Collections.sort(pos);
        }

        bfs();


        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static void bfs() {
        int count = 1;
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);

        visited[R] = true;
        result[R] = count++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int num : list.get(cur)) {
                if (!visited[num]) {
                    queue.add(num);
                    visited[num] = true;
                    result[num] = count++;
                }
            }
        }
    }
}