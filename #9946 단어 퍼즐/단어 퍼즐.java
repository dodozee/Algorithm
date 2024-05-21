import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int caseNum = 1;
        
        while (true) {
            String original = sc.nextLine();
            String collected = sc.nextLine();
            
            if (original.equals("END") && collected.equals("END")) {
                break;
            }
            
            String sortedOriginal = sortString(original);
            String sortedCollected = sortString(collected);
            
            if (sortedOriginal.equals(sortedCollected)) {
                System.out.println("Case " + caseNum + ": same");
            } else {
                System.out.println("Case " + caseNum + ": different");
            }
            
            caseNum++;
        }
    }
    
    public static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}