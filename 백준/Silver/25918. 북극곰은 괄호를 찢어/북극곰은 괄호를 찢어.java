import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        int answer = -1;
        
        if (length % 2 == 0) {
            char[] parentheses = reader.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            
            for (char parenthesis : parentheses) {
                if (stack.isEmpty() || stack.peek().equals(parenthesis)) {
                    stack.push(parenthesis);
                } else {
                    stack.pop();
                }
                answer = Math.max(answer, stack.size());
            }
            
            if (!stack.isEmpty()) {
                answer = -1;
            }
        }
        
        System.out.println(answer);
        reader.close();
    }
}