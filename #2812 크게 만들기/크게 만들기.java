import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int length = n - k;// 출력할 숫자의 길이

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (!stack.empty()) {
                while(!stack.empty() && k > 0 && stack.peek() < str.charAt(i)) {
                    stack.pop();
                    k--;
                }
            }
            stack.push(str.charAt(i));
        }
        while (stack.size() != length) {

            stack.pop();
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}