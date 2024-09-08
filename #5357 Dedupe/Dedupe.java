import java.util.*;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        
        for (int t = 0; t < testCase; t++) {
            String[] strArr = sc.next().split("");
            
            String result = strArr[0];
            for (int s = 0; s < strArr.length - 1; s++) {
                if (strArr[s].equals(strArr[s + 1])) {
                    continue;
                }
                else {
                    result += strArr[s + 1];
                    
                }
            }
            
            System.out.println(result);
        }
 
    }
}