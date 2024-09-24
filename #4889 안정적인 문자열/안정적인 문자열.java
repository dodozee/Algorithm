import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        // 선언
        Stack<Character> stack = new Stack<>();
        int num = 1;
        while(true) {
            int change = 0; 
            String str = sc.next(); 
            if(str.contains("-")) 
                return;

            for (int j = 0; j < str.length(); j++) { 
                if (str.charAt(j) == '{') 
                    stack.push(str.charAt(j));
                else { 
                    if (stack.isEmpty()) { 
                        stack.push('{');
                        change++;             
                    } else if (stack.peek() == '{') 
                        stack.pop(); 
                }
            }

            System.out.println(num+". "+((stack.size()/2)+change)); 
            stack.clear(); 
            num++;         
        }
    }
}