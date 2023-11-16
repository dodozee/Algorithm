import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    static int numStudents, numFriendships;
    static ArrayList<ArrayList<Integer>> friendGraph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numStudents = Integer.parseInt(br.readLine());
        numFriendships = Integer.parseInt(br.readLine());
        for (int i = 0; i <= numStudents; i++) friendGraph.add(new ArrayList<>());
        visited = new boolean[numStudents + 1]; 
        visited[1] = true;

        StringTokenizer st;
        for (int i = 0; i < numFriendships; i++) { // 양방향 인접리스트
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            friendGraph.get(from).add(to);
            friendGraph.get(to).add(from);
        }
        dfs(1, 0);

        int answer = 0;
        for (int i = 2; i < visited.length; i++) {
            if (visited[i]) answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int node, int count) {
        if (count == 2) {
            return;
        }
        for (int neighbor : friendGraph.get(node)) {
            visited[neighbor] = true;
            dfs(neighbor, count + 1);
        }
    }
}
