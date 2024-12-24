import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        long sum = 0;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {//스택이 비어있지 않고
                if (stack.peek() <= num) {
                    stack.pop();
                }else break;
            }
            sum += stack.size();
            stack.push(num);


        }
        System.out.println(sum);


    }
}