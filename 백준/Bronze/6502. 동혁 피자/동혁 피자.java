import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int testCase = 0;
        
        while (true) {
            testCase++;
            
            int r = sc.nextInt();
            if (r == 0) break;
            
            int w = sc.nextInt();
            int l = sc.nextInt();
            
            boolean isPizzaFit = isPizzaFitOnTable(r, w, l);
            
            System.out.println("Pizza " 
                            + testCase 
                            + (isPizzaFit ? " fits on the table." : " does not fit on the table."));
        }
    }
    
    private static boolean isPizzaFitOnTable(int r, int w, int l) {
        double diagonal = Math.sqrt(w * w + l * l);
        
        return diagonal <= 2 * r;
    }
    
}