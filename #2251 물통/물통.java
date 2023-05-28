import java.io.*;
import java.util.*;

public class Main{ //박두지 화이팅!!
    static int A, B , C;
    static boolean[][] visited;
    static Set<Integer> answer = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[A + 1][B + 1];

        dfs(0, 0, C);

        answer.stream()
                .forEach(amount -> System.out.print(amount + " "));
    }

    static void dfs(int a, int b, int c) {
        if (visited[a][b]) { //방문한 적이 있다면 종료
            return;
        }

        visited[a][b] = true;
        if (a == 0) {
            answer.add(c);
        }

        // a->b 이동
        if (a + b > B) {
            dfs((a + b) - B, B, c);
        }else{
            dfs(0, a + b, c);
        }
        // b->a 이동
        if (b + a > A) {
            dfs(A, (a + b) - A, c);
        }else{
            dfs(a+b,0, c);
        }
        // a->c 이동
        if (a+c > C) {
            dfs((a + c) - C, b, C);
        }else{
            dfs(0,b,a+c);
        }
        // b->c 이동
        if (b + c > C) {
            dfs(a, (b + c) - C, C);
        } else {
            dfs(a, 0, b + c);
        }

        // c->a 이동
        if (c + a > A) {
            dfs(A, b, (c + a) - A);
        } else {
            dfs(c + a, b, 0);
        }

        // c->b 이동
        if (c + b > B) {
            dfs(a, B, (c + b) - B);
        } else {
            dfs(a, c + b, 0);
        }

    }
}