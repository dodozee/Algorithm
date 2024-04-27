import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gate = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        parent = new int[gate+1]; // 0번은 사용하지 않음
        for (int i = 1; i <= gate; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < p; i++) {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);
            if (emptyGate != 0) { // 빈게이트가 없으면 종료
                union(emptyGate, emptyGate - 1);
                result++;
            }else break;

        }
        System.out.println(result);
    }

    private static int find(int x) {
        if(parent[x] == x) return x;// 자기 자신이 부모인 경우
        else
            return parent[x] = find(parent[x]); // 부모를 찾아서 저장
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;// x의 부모를 y로 설정
        }
    }


}