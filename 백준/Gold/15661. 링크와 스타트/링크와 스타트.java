import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int T;
    public static int MIN;
    public static int[] teamA;
    public static boolean[] visited;
    public static int[][] ability;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            for (int j = 0; j < N; j++) {
                int score = Integer.parseInt(split[j]);
                ability[i][j] = score;
                MIN += score;
            }
        }

        for (T = 1; T < N; T++) {
            teamA = new int[T];
            dfs(0, 0);
        }

        bw.write(MIN + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int index) {
        if (depth == T) {
            List<Integer> teamBList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    teamBList.add(i);
                }
            }
            Object[] teamB = teamBList.toArray();
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < T; i++) {
                for (int j = 0; j < T; j++) {
                    sumA += ability[teamA[i]][teamA[j]];
                }
            }
            for (int i = 0; i < N - T; i++) {
                for (int j = 0; j < N - T; j++) {
                    sumB += ability[(int) teamB[i]][(int) teamB[j]];
                }
            }
            MIN = Math.min(MIN, Math.abs(sumA - sumB));
            return;
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                teamA[depth] = i;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}