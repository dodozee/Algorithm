import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[n];

        Deque<Integer> dq = new LinkedList<>();

        //순서 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //arr 배열 역순
        reverse(arr);


        for (int i = 1; i <= n; i++) {
            int num = arr[i-1];

            if (num == 1) {
                dq.addFirst(i);
            } else if (num == 2) {
                int top = dq.removeFirst();
                dq.addFirst(i);
                dq.addFirst(top);
            } else {
                dq.addLast(i);
            }
        }

        // 최종적으로 Deque에 있는 카드들을 순서대로 StringBuilder에 추가
        StringBuilder sb = new StringBuilder();
        while (dq.size() != 0) {
            sb.append(dq.removeFirst() + " ");
        }

        System.out.println(sb);

    }

    static void reverse(Integer[] array) {
        Collections.reverse(Arrays.asList(array));
    }
}