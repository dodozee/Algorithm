import java.util.*;
import java.io.*;
public class Main { //박두지 화이팅!! 갓천대 컴공 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // "."이 입력될 때까지 반복
        while (!(input = br.readLine()).equals(".")) {
            // isBalanced 메소드를 호출하여 균형이 맞는지 검사하고 결과를 출력
            System.out.println(isBalanced(input) ? "yes" : "no");
        }
    }

    private static boolean isBalanced(String input) {
        // 괄호를 저장할 스택 생성
        Stack<Character> stack = new Stack<>();

        // 문자열을 한 글자씩 순회하면서 괄호를 스택에 넣거나 뺌
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[') {
                // 왼쪽 괄호는 스택에 넣음
                stack.push(c);
            } else if (c == ')') {
                // 오른쪽 소괄호가 나온 경우, 스택에서 왼쪽 소괄호를 꺼내서 짝이 맞는지 검사
                if (stack.isEmpty() || stack.peek() != '(') {
                    // 스택이 비어있거나 짝이 맞지 않으면 균형이 맞지 않음
                    return false;
                }
                stack.pop(); // 짝이 맞으면 스택에서 꺼냄
            } else if (c == ']') {
                // 오른쪽 대괄호가 나온 경우, 스택에서 왼쪽 대괄호를 꺼내서 짝이 맞는지 검사
                if (stack.isEmpty() || stack.peek() != '[') {
                    // 스택이 비어있거나 짝이 맞지 않으면 균형이 맞지 않음
                    return false;
                }
                stack.pop(); // 짝이 맞으면 스택에서 꺼냄
            }
        }

        // 문자열을 모두 순회한 후, 스택이 비어있는지 검사하여 모든 괄호의 짝이 맞는지 검사
        return stack.isEmpty();
    }
}