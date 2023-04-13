import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { //박두지 화이팅!!! 갓천대 화이팅!!!
    static int n;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];// 각 열에서 선택된 행의 인덱스를 저장할 배열

        PriorityQueue<Node> pq = new PriorityQueue<>();//우선순위큐 생성

        //표 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; //몇 번째 큰 수인지 세는 변수
        int max = Integer.MIN_VALUE;//최대값 저장 변수

        //가장 큰수 찾기
        for (int i = 0; i < n; i++) {
            for(int j=0; j<n; j++) {
                pq.add(new Node(i, j, arr[i][j]));
                visited[i][j] = true;
                max = Math.max(max, arr[i][j]);
            }
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            cnt++;

            if (cnt == n) {
                System.out.println(cur.num);
            }

//            if (cur.j > 0 && !visited[cur.i][cur.j - 1]) { // 왼쪽
//                pq.add(new Node(cur.i, cur.j - 1, arr[cur.i][cur.j - 1]));
//                visited[cur.i][cur.j - 1] = true;
//                max = Math.max(max, arr[cur.i][cur.j - 1]);
//            }
//
//            if (cur.i > 0 && !visited[cur.i - 1][cur.j]) { // 위쪽
//                pq.add(new Node(cur.i - 1, cur.j, arr[cur.i - 1][cur.j]));
//                visited[cur.i - 1][cur.j] = true;
//                max = Math.max(max, arr[cur.i - 1][cur.j]);
//            }
        }
    }
}
class Node implements Comparable<Node> {
    int i,j, num;

    public Node(int i, int j, int num) {
        this.i=i;
        this.j=j;
        this.num = num;
    }

    @Override
    public int compareTo(Node o){
        return Integer.compare(o.num, this.num);
    }
}

