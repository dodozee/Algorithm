import java.io.*;
import java.util.*;

public class Main { //모든 그래프를 탐색하는거라 dfs, bfs 둘다 가능 -> 보통 bfs가 더 좋음 + MST
    static int N,M, isLandCount;
    static int[][] map;
    static int[] parents;
    static Queue<int[]> q ;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean[][] check;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isLandCount = 2;
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    isLandIndexing(j,i, isLandCount);
                    isLandCount++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    makeBridge(j, i, map[i][j]);
                }
            }
        }

        isLandCount--;
        parents = new int[isLandCount];

        for (int i = 1; i < isLandCount; i++) {
            parents[i] = i;
        }

        int result = shortestPath();
        System.out.println(result == 0 ? -1 : result);
    }

    private static void isLandIndexing(int x, int y, int isLandCount) {
        q = new LinkedList<>();

        q.add(new int[]{x,y});
        map[y][x] = isLandCount;
        check[y][x] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || ny < 0 || nx > M -1  || ny > N -1 || check[ny][nx])
                    continue;


                if (map[ny][nx] == 1) {
                    map[ny][nx] = isLandCount;
                    check[ny][nx] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void makeBridge(int x, int y, int idx) {
        q = new LinkedList<>();
        check = new boolean[N][M];

        for (int i = 0; i < 4; i++) {
            q.add(new int[]{x, y, 0});
            check[y][x] = true;

            while (!q.isEmpty()) {
                int[] p = q.poll();
                int px = p[0];
                int py = p[1];
                int move = p[2];

                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || ny < 0 || nx > M -1  || ny > N -1 || check[ny][nx])
                    continue;


                if (map[ny][nx] != idx) {
                    if (map[ny][nx] != 0) {
                        int from = idx - 1;
                        int to = map[ny][nx] - 1;
                        if (move > 1) {
                            pq.add(new Node(from, to, move));
                            break;
                        }
                    }else{
                        check[ny][nx] = true;
                        q.add(new int[]{nx, ny, move + 1});
                        }

                    }
            }
            q.clear();
        }
    }

    private static int shortestPath(){
        int sum = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Node node = pq.poll();
            int x = node.from;
            int y = node.to;

            if (find(x) != find(y)) {
                sum += node.value;
                union(x, y);
            }
        }

        int rx = parents[1];
        for (int i = 2; i < isLandCount; i++) {
            if (rx != find(parents[i])) {
                return 0;
            }
        }
        return sum;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parents[y] = x;
        }else{
            parents[x] = y;
        }
    }
}

class Node implements Comparable<Node>{
    int to;
    int from;
    int value;

    public Node(int to, int from, int value){
        this.to = to;
        this.from = from;
        this.value = value;
    }

    @Override
    public int compareTo(Node o){
        return this.value - o.value;
    }
}

