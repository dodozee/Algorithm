import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//박두지 화이팅!!
    static int[][] land;
    static int N, M, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        land = new int[N][M];
        int maxHeight = 0;
        int minHeight = 256;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, land[i][j]);
                minHeight = Math.min(minHeight, land[i][j]);
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;

        for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
            int time = 0;
            int blocks = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - targetHeight;

                    if (diff > 0) {
                        time += diff * 2;
                        blocks += diff;
                    } else if (diff < 0) {
                        time += -diff;
                        blocks -= -diff;
                    }
                }
            }

            if (blocks >= 0 && time <= answerTime) {
                answerTime = time;
                answerHeight = targetHeight;
            }
        }

        System.out.println(answerTime + " " + answerHeight);
    }
}
