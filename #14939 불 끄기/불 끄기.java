import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {
    static int[][] arr = new int[10][10];
    static int[][] tempArr = new int[10][10];
    static int tempAnswer = Integer.MAX_VALUE;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1,0};
    static int[] dy = {1, -1, 0, 0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(p -> p.equals("#") ? 0 : 1)
                    .toArray();
        }

        for(int i = 0; i < 1024; i++) {
            init();


            for (int j = 1; j <= 10; j++) {
                int num = 1024;
                num = num >> j;

                if ((i & num) > 0) {
                    tempAnswer++;
                    click(0, j - 1);
                }
            }

            for (int j = 1; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (tempArr[j - 1][k] == 1) {
                        tempAnswer++;
                        click(j, k);
                    }
                }
            }

            if(Arrays.stream(tempArr[9]).sum()==0) {
                answer = Math.min(answer, tempAnswer);
            }

        }
            System.out.println(answer == Integer.MAX_VALUE ? "-1" : answer);

    }

    private static void click(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10) continue;

            tempArr[nx][ny] = tempArr[nx][ny] == 0 ? 1 : 0;
        }
    }

    private static void init() {
        tempAnswer = 0;
        for (int i = 0; i < 10; i++) {
            tempArr[i] = arr[i].clone();
        }
    }

}