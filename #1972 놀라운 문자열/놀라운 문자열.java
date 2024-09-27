import java.util.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input;
        
        while (!(input = sc.nextLine()).equals("*")) {
            if (isSurprising(input)) {
                System.out.println(input + " is surprising.");
            } else {
                System.out.println(input + " is NOT surprising.");
            }
        }
    }
    private static boolean isSurprising(String s) {
        for (int d = 0; d < s.length() - 1; d++) {
            HashMap<String, Integer> pairs = new HashMap<>();
            
            for (int i = 0; i + d < s.length() - 1; i++) {
                String pair = s.charAt(i) + "" + s.charAt(i + d + 1);
                
                if (pairs.containsKey(pair)) {
                    return false;
                }
                pairs.put(pair, 1);
            }
        }
        
        return true;
    }
}