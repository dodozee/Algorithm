import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!! 갓천대 컴공 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        boolean inTag = false; // 태그 내부에 있는지 여부를 저장하는 변수

        for (char c : s.toCharArray()) {
            if (c == '<') {
                //스택에 쌓인 문자열을 뒤집어서 출력
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(c);
                inTag = true;
            } else if (c == '>') {
                System.out.print(c);
                inTag = false;
            } else if(inTag){
                System.out.print(c);;//inTag가 true일땐 뒤집지 않고 출력
            }else {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(c);
                }else{
                    stack.push(c);
                }
            }

        }
        // 마지막 단어 처리
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}