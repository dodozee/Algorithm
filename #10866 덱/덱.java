
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd){
                case "push_front":
                dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    System.out.println(dq.isEmpty() ? -1 : dq.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(dq.isEmpty() ? -1 : dq.pollLast());
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    System.out.println(dq.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(dq.isEmpty() ? -1 : dq.getFirst());
                    break;
                case "back":
                    System.out.println(dq.isEmpty() ? -1 : dq.getLast());
            }
        }

    }
}
