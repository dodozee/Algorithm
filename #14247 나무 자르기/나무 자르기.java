import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long sum = 0;

        int[][] treeInfo = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        //나무 초기 길이 정보
        for (int i = 0; i < n; i++) {
            treeInfo[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        //나무 성장 정보
        for (int i = 0; i < n; i++) {
            treeInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(treeInfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];//성장 정보 기준으로 오름차순 정렬
            }
        });

        for (int day = 0; day < n; day++) {
            sum += treeInfo[day][0] + (long) treeInfo[day][1] * day;
        }

        bw.write(sum + "");
        br.close();
        bw.flush();

    }
}