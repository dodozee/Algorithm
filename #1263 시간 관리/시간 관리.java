import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] work = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ts = br.readLine().split(" ");
            work[i][0] = Integer.parseInt(ts[0]);
            work[i][1] = Integer.parseInt(ts[1]);
        }

        Arrays.sort(work, (a, b) -> b[1] - a[1]);

        int ans = work[0][1] - work[0][0];//첫번째 일을 한다고 가정

        for (int i = 1; i < n; i++) {
            if (work[i][1] < ans) {
                ans = work[i][1];
            }
            ans -= work[i][0];
        }
        if(ans > 0 ) {
            wr.write(ans + "\n");
        } else {
            wr.write("-1\n");
        }

        wr.flush();
        wr.close();
    }
}


