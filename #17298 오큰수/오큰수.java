import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                A[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            A[stack.pop()] = -1;

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(' ');
        }

        System.out.println(sb);


    }
}