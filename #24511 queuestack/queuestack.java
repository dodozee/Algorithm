import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] typeArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            typeArray[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (typeArray[i] == 0) { //
                deque.addLast(num);
            }

        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        br.close();

        method(sb, st, deque, M);
    }

    private static void method(StringBuilder sb, StringTokenizer st, Deque<Integer> deque, int M) {
        while(M-->0){
            int moveValue = Integer.parseInt(st.nextToken());
            //만약 큐만 없고 스택으로 이루어졌다해도 바로 빼기 때문에 (pollLast())해도 문제가 되지 않음
            deque.addFirst(moveValue);
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb.toString());
    }
}