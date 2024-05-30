import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.valueOf(st.nextToken());
        int W = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int h = (H - 1) / (N + 1) + 1;
        int w = (W - 1) / (M + 1) + 1;

        int ans = h * w;
        System.out.print(ans);

    }
}
