import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
      
        int NUMBER_OF_STUDENT = Integer.parseInt(br.readLine());
        int student[] = new int [NUMBER_OF_STUDENT];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<NUMBER_OF_STUDENT;i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        int getFoodOrder = 1;
        Stack<Integer>stack = new Stack<Integer>();
        for(int i=0;i<NUMBER_OF_STUDENT;i++) {
            if(student[i] != getFoodOrder) {
                if(!stack.isEmpty() && stack.peek() == getFoodOrder) {
                    stack.pop();
                    i--;
                    getFoodOrder++;
                }else {
                    stack.push(student[i]);
                }
                
            }else {
                getFoodOrder++;
            }
        }
        boolean ans = true;
        
        for(int i=0;i<stack.size();i++) {
            int stu = stack.pop();
            if(stu == getFoodOrder) {
                getFoodOrder++;
            }else {
                ans = false;
                break;
            }
        }
        if(ans) {
            sb.append("Nice\n");
        }else {
            sb.append("Sad\n");
        }
        bw.write(sb.toString());
        bw.flush();
        
    }

    
}