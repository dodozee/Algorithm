import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;

    private static int N, K;
    private static final int MAX = 100_001;
    private static final int INF = Integer.MAX_VALUE / 2;

    private static class Coordinate {
        int idx;
        int count;

        private Coordinate(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } 

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        if (N >= K) {
            sb.append(N - K).append('\n').append(1);
            return sb.toString();
        }

        int[] ret = BFS();
        sb.append(ret[0]).append('\n').append(ret[1]);
        return sb.toString();
    }

    private static int[] BFS() {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        int[] memo = new int[MAX];
        Arrays.fill(memo, INF);

        que.offer(new Coordinate(N, 0));
        memo[N] = 0;
        int minTime = INF;
        int ans = 0;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (cur.idx == K) {
                if (cur.count < minTime) {
                    minTime = cur.count;
                    ans = 1;
                } else {
                    ans++;
                }
                continue;
            }

            if (cur.idx + 1 < MAX && memo[cur.idx + 1] >= memo[cur.idx] + 1) {
                memo[cur.idx + 1] = memo[cur.idx] + 1;
                que.offer(new Coordinate(cur.idx + 1, memo[cur.idx + 1]));
            }

            if (cur.idx - 1 >= 0 && memo[cur.idx - 1] >= memo[cur.idx] + 1) {
                memo[cur.idx - 1] = memo[cur.idx] + 1;
                que.offer(new Coordinate(cur.idx - 1, memo[cur.idx - 1]));
            }

            if (cur.idx * 2 < MAX && memo[cur.idx * 2] >= memo[cur.idx] + 1) {
                memo[cur.idx * 2] = memo[cur.idx] + 1;
                que.offer(new Coordinate(cur.idx * 2, memo[cur.idx * 2]));
            }
        }

        return new int[]{minTime, ans};
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    } 
}