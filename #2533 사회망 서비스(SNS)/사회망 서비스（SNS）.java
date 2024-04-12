import java.io.*;
import java.util.*;


/**
 * dp
 * 얼리 아답터 : 어떤 새로운 아이디어를 먼저 받아들인 사람을 일컫는다.
 * 얼리 아답터가 아닌 사람들은 "자신의 주변의 모든 친구들이 얼리아답터일 때만" 새로운 아이디어를 받아들인다.
 * <p>
 * 결국 어떤 아이디어를 SNS 상에서 전파하고자 할 때, "최소한의 얼리 아답터를 확보"하여 모든 사람에게 전파하는 것이 목표이다.
 * <p>
 * 조건 : 모든 두 정점 사이에 이들은 잇는 경로가 존재는 하지만 사이클은 존재하지 않는 경우만 고려한다.
 */
public class Main {
    static class Node{
        int n ;// 노드 번호
        Node next; // 다음 노드
        Node(int n, Node next){
            this.n = n;
            this.next = next;
        }
    }
    static int n;
    static boolean[] visited;
    static Node[] tree;
    static int[][] dp; //dp : 해당 지점까지의 얼리어답터의 최소 인원수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        tree = new Node[n + 1];

        StringTokenizer st;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start] = new Node(end, tree[start]);
            tree[end] = new Node(start, tree[end]);
        }


        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));// 1번 노드가 얼리어답터인 경우와 아닌 경우 중 최소값 출력
    }

    static void dfs(int n){
        visited[n] = true;
        dp[n][0] = 0; // 해당 노드가 얼리어답터가 아닌 경우
        dp[n][1] = 1; // 해당 노드가 얼리어답터인 경우

        for (Node next = tree[n]; next != null; next = next.next) {
            if (!visited[next.n]) {
                dfs(next.n);
                dp[n][0] += dp[next.n][1]; // 해당 노드가 얼리어답터가 아닌 경우는 자식 노드가 얼리어답터인 경우만 가능
                dp[n][1] += Math.min(dp[next.n][0], dp[next.n][1]); // 해당 노드가 얼리어답터인 경우는 자식 노드가 얼리어답터인 경우와 아닌 경우 중 최소값만큼만 가능
            }
        }
    }

}