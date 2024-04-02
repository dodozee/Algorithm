import java.io.*;
import java.util.*;

public class Main { //치킨먹고싶다..다익스트라 알고리즘 사용
    static int N, M, R;
    static int[] item;
    static ArrayList<ArrayList<Position>> a;
    static int[] d; //최단 거리 배열
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//출력
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        item = new int[N+1];
        d = new int[N+1];
        check = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        a = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        //양방향 인접리스트 생성
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            a.get(start).add(new Position(end, cost));
            a.get(end).add(new Position(start, cost));
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        bw.write(ans + "\n");
        bw.flush();
        


    }

    private static int dijkstra(int start) {
        Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(check, false);

        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.add(new Position(start, 0));

        d[start] = 0;

        while (!pq.isEmpty()) {
            Position cur = pq.poll();
            int curNode = cur.nodeNum;

            if (check[curNode]) continue;
            check[curNode] = true;

            for(Position position : a.get(curNode)){
                int nextNode = position.nodeNum;
                int nextCost = position.cost;

                if (d[nextNode] > d[curNode] + nextCost) {
                    d[nextNode] = d[curNode] + nextCost;
                    pq.add(new Position(nextNode, d[nextNode]));
                }
            }
        }
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (d[i] <= M) {
                result += item[i];
            }
        }
        return result;
    }
}

class Position implements Comparable<Position> {
    int nodeNum;
    int cost;
    public Position(int nodeNum, int cost) {
        this.nodeNum = nodeNum;
        this.cost = cost;
    }

    @Override
    public int compareTo(Position o) {
        return this.cost - o.cost;
    }
}
