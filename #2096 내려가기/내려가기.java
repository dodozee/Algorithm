import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] map = new int[n+1][4];
        int[][] dpMin = new int[n+1][4];
        int[][] dpMax = new int[n+1][4];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 3; i++) {
            dpMin[1][i] = map[1][i];
            dpMax[1][i] = map[1][i];
        }




        for (int i = 2; i <= n; i++) {
            dpMin[i][1] = Math.min(dpMin[i-1][1]+map[i][1], dpMin[i-1][2] + map[i][1]);
            dpMin[i][2] = Math.min(dpMin[i-1][1]+map[i][2], Math.min(dpMin[i-1][2]+map[i][2], dpMin[i-1][3]+map[i][2]));
            dpMin[i][3] = Math.min(dpMin[i-1][2]+map[i][3], dpMin[i-1][3]+map[i][3]);

            dpMax[i][1] = Math.max(dpMax[i-1][1]+map[i][1], dpMax[i-1][2] + map[i][1]);
            dpMax[i][2] = Math.max(dpMax[i-1][1]+map[i][2], Math.max(dpMax[i-1][2]+map[i][2], dpMax[i-1][3]+map[i][2]));
            dpMax[i][3] = Math.max(dpMax[i-1][2]+map[i][3], dpMax[i-1][3]+map[i][3]);
        }

        int min = Math.min(dpMin[n][1], Math.min(dpMin[n][2], dpMin[n][3]));
        int max = Math.max(dpMax[n][1], Math.max(dpMax[n][2], dpMax[n][3]));
        bw.write(max + " " + min + "\n");
        bw.flush();
        bw.close();





    }
}


