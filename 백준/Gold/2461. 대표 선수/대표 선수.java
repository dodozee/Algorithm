import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] students = new int[N][M];
        for (int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] indexs = new int[N];
        for (int i = 0; i < N; i++) {
            Arrays.sort(students[i]);
            indexs[i] = 0;
        }
        int min = Integer.MAX_VALUE;
        while(true) {
            int partialMin = students[0][indexs[0]];
            int partialMax = students[0][indexs[0]];
            int minIdx = 0;
            for (int i = 1; i < N; i++) {
                if (partialMin > students[i][indexs[i]]){
                    partialMin = students[i][indexs[i]];
                    minIdx = i;
                }
                if (partialMax < students[i][indexs[i]]){
                    partialMax = students[i][indexs[i]];
                }
            }
            if ((partialMax - partialMin) < min) {
                min = (partialMax - partialMin);
            }
            if (++indexs[minIdx] >= M)
                break;
        }
        System.out.println(min);
    }
}