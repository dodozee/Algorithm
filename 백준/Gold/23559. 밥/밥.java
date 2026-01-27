import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class node implements Comparable<node> {
        int a, b;

        public node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(node o) {
            return Math.abs(o.a - o.b) - Math.abs(a - b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<node> pq = new PriorityQueue<>();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new node(a, b));
        }

        while (!pq.isEmpty()) {
            node now = pq.poll();

            if (M - 5000 >= pq.size() * 1000 && now.a > now.b) {
                M -= 5000;
                answer += now.a;
            } else {
                M -= 1000;
                answer += now.b;
            }
        }

        System.out.println(answer);
    }
}
