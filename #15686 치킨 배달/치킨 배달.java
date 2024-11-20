import java.io.*;
import java.util.*;

/*
분석

 */
public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static int ans;
    static boolean[] open;
    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;

        open = new boolean[chicken.size()];

        dfs(0, 0);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int start, int count) {
        if (count == M) {
            int res = 0;
            for (int i = 0; i < house.size(); i++) {
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        min = Math.min(min, dist);
                    }
                }
                res += min;
            }
            ans = Math.min(ans, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i+1, count+1);
            open[i] = false;
        }

    }
}

class Point{
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
