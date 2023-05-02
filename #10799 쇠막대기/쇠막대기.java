import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') { // 여는 괄호일 때
                stack.push(i); // 인덱스를 스택에 저장
            } else { // 닫는 괄호일 때
                if (stack.peek() + 1 == i) { // 레이저일 경우
                    stack.pop(); // 레이저를 위해 스택에 저장된 여는 괄호를 제거
                    answer += stack.size(); // 스택에 남아있는 여는 괄호의 개수가 쇠막대기의 개수
                } else { // 쇠막대기의 끝일 경우
                    stack.pop();
                    answer += 1; // 쇠막대기의 끝일 때는 1을 더해줌
                }
            }
        }

        System.out.println(answer);
    }
}
