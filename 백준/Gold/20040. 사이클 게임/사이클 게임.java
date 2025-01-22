import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;


public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (find(x) == find(y)) {
                System.out.println(i + 1);
                return;
            } else {
                union(x, y);
            }
        }

        System.out.println(0);





    }

    static int find(int x) {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) { // y가 더 크면
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}