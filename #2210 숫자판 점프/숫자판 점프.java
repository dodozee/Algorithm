import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[] answerArray;
    public static ArrayList<String> resultList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        answerArray = new int[6];
        resultList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                dfs(i, j, 1);

        System.out.println(resultList.size());
    }

    public static void dfs(int x, int y, int depth) {
        if (depth > 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answerArray.length; i++)
                sb.append(answerArray[i]);

            if (!resultList.contains(sb.toString()))
                resultList.add(sb.toString());

            return;
        }

        answerArray[depth - 1] = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5)
                dfs(nx, ny, depth + 1);
        }
    }
}


