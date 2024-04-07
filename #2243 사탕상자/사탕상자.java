import java.io.*;
import java.util.*;

/**
 * 사탕상자
 *
 * A가 1인 경우 : 사탕상자에서 사탕을 꺼내는 경우
 * A가 2인 경우 : 사탕상자에 사탕을 넣는 경우 B는 달기의 정도(1이 젤 맞있음 점점 증가할수록 맞 없어짐),
 * C는 사탕 넣는 개수인데 양수이면 넣는거고 음수이면 빼는 것.
 *
 *
 * 세그먼트 트리 문제
 */

public class Main {
    static final int SIZE = 1000001;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        tree = new int[SIZE * 4];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int candy = query(1, SIZE, 1, a);
                sb.append(candy).append("\n");
            }else{
                int b = Integer.parseInt(st.nextToken());
                update(1, SIZE, 1, a, b);
            }
        }

        System.out.println(sb);
    }

    private static int query(int s, int e, int idx, int target) {
        if (s == e) {
            update(1, SIZE, 1, s, -1);
            return s;
        }

        int mid = (s + e) / 2;
        if (target <= tree[idx * 2]) {
            return query(s, mid, idx * 2, target);
        } else {
            return query(mid + 1, e, idx * 2 + 1, target - tree[idx * 2]);
        }

    }


    private static void update(int s, int e, int idx, int target, int dif){
        if(target < s || e <target) return;

        tree[idx] += dif;
        if(s == e) return;

        int mid = (s + e) / 2;
        update(s, mid, idx*2, target, dif);
        update(mid + 1, e, idx * 2 + 1, target, dif);
    }

}