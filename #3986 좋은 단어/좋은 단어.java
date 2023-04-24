import java.util.Scanner;
import java.util.Stack;

public class Main {//박두지 화이팅!!! 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
