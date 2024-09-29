
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> xx = new ArrayList<>();
        ArrayList<Integer> yy = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            xx.add(Integer.parseInt(st.nextToken()));
            yy.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(xx);
        Collections.sort(yy);

        int p = 1;
        int q = 1;

        if (M % 2 == 1) {
            p = xx.get(M / 2);
            q = yy.get(M / 2);
        } else {
            p = (xx.get(M/2) + xx.get(M / 2 - 1)) / 2;
            q = (yy.get(M/2) + yy.get(M / 2 - 1)) / 2;
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {
            answer += Math.abs(xx.get(i) - p) + Math.abs(yy.get(i) - q);
        }

        System.out.println(answer);
    }
}