import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 1) {
                    union(i, j);

                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            int next = find(Integer.parseInt(st.nextToken()));

            if(start != next) {
                bw.write("NO\n");
                bw.flush();
                return;
            }

        }
        bw.write("YES\n");
        bw.flush();


    }

    private static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            if(i < j) {
                parent[j] = i;
            } else {
                parent[i] = j;
            }
        }
    }

    private static int find(int i) {
        if (parent[i] == i) {
            return i;
        } else {
            return parent[i] = find(parent[i]);
        }
    }
}
