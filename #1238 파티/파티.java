import java.io.*;
import java.util.*;


public class Main {//박두지 화이팅!!!
    static ArrayList<ArrayList<Town>> arrList, reverseArrList;
    static int N, M, X;
    static final int INF = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arrList = new ArrayList<>();
        reverseArrList = new ArrayList<>(); 

        for (int i = 0; i <= N; i++) {
            arrList.add(new ArrayList<>());
            reverseArrList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arrList.get(start).add(new Town(end, weight));
            reverseArrList.get(end).add(new Town(start, weight));
        }

        int[] dist1 = dijkstra(arrList); 
        int[] dist2 = dijkstra(reverseArrList); 

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        bw.write(ans + "\n");
        bw.flush();
    }

    // 다익스트라 알고리즘
    public static int[] dijkstra(ArrayList<ArrayList<Town>> a) {
        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(X, 0));

        boolean[] check = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[X] = 0;

        while (!pq.isEmpty()) {
            Town curTown = pq.poll();
            int cur = curTown.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Town town : a.get(cur)) {
                    if (!check[town.end] && distance[town.end] > distance[cur] + town.weight) {
                        distance[town.end] = distance[cur] + town.weight;
                        pq.add(new Town(town.end, distance[town.end]));
                    }
                }
            }
        }
        return distance;
    }

}

class Town implements Comparable<Town> {
    int end;
    int weight;

    Town(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Town arg0) {
        return weight - arg0.weight;
    }
}

