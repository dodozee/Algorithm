
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {
  static int[] arr;
  static boolean[] visited;
  static boolean[] done;
  static int count;
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!done[i]) {
                    dfs(i);
                }
            }

            bw.write(n - count + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int x) {
        if (visited[x]) {
            done[x] = true;
            count++;
        } else {
            visited[x] = true;
        }

        if (!done[arr[x]]) {
            dfs(arr[x]);
        }

        visited[x] = false; //방문한 노드를 다시 방문할 수 있도록 false로 바꿔줌
        done[x] = true;
    }
}


