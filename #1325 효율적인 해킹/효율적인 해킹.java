
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int max;
    static int[] countArr;
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        countArr = new int[n + 1];

        arr = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        for (int i = 1; i <= n; i++) {
            if (max < countArr[i]) {
                max = countArr[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (max == countArr[i]) {
                System.out.print(i + " ");
            }
        }

    }
    static void bfs(int start) {
        Queue <Integer> que = new ArrayDeque<Integer>();

        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()) {
            int now = que.poll();
            for (int i : arr[now]) {
                if (visited[i]) continue;
                countArr[i]++; // i가 해킹할 수 있는 숫자 증가
                visited[i] = true;
                que.add(i);
            }
        }
    }
    public static void dfs(int x) {
        visited[x] = true;

        for (int i : arr[x]) {
            if (!visited[i]) {
                countArr[i]++;
                dfs(i);
            }
        }
    }
}


