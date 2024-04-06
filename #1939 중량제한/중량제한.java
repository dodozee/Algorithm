import java.io.*;
import java.util.*;

/**
 * 두 섬 사이에서 연결된 다리로 옮길 수 있는 최대 중량을 구하면 됨.
 * 특정 지점을 탐색해야 하기 때문에 DFS를 활용 그리고 빠르게 탐색하기 위해 이분탐색을 활용
 *
 * 설계
 * 1.이분 탐색을 통해 middle value를 구한다.
 * 2. middle value를 기준으로 DFS를 통해 두 섬을 연결할 수 있는지 확인한다.
 * 3. middle value를 기준으로 두 섬을 연결할 수 있다면 left = middle + 1로 갱신하고, 두 섬을 연결할 수 없다면 right = middle - 1로 갱신한다.
 * 4. left와 right가 같아질 때까지 1~3을 반복한다.
 * 5. left가 최대 중량이 된다.
 *
 *
 */

public class Main {

    static int answer;
    static List<City>[] cities;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        cities = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cities[a].add(new City(b, c));
            cities[b].add(new City(a, c)); //양방향

            right = Math.max(right, c);//그래프 최대 중량 구하기
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        System.out.println(binarySearch(left, right, from, to));

    }
    private static int binarySearch(int left, int right, int from, int to) {
        int result = 0;
        while(left <= right){
            int middle = (left + right) / 2;
            answer = -1;
            visited = new boolean[cities.length];
            dfs(from, to, middle);
            if (answer == -1) {
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }

        return right;
    }

    private static void dfs(int pos, int target, int limit) {
        if (pos == target) {
            answer = pos;
            return;
        }

        visited[pos] = true;
        for (City c : cities[pos]) {
            if (!visited[c.to] && c.weight >= limit) {
                dfs(c.to, target, limit);
            }
        }
    }
}

class City{
    int to;
    int weight;

    public City(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}