

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while(!str.equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(' || arr[i] == '[') {
                    stack.push(arr[i]);
                }else if(arr[i] == ')'){
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    } else
                        stack.pop();

                    }else if(arr[i] == ']'){
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }


            }
            if (stack.isEmpty() && flag) {
                System.out.println("yes");
            } else if(!stack.isEmpty() || !flag) {
                System.out.println("no");
            }
            str = br.readLine();

        }
    }
}
