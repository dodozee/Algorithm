import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine(); 
        
        int countOne = 0;  
        int countTwo = 0;  
        
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.substring(i, i + 3).equals("JOI")) {
                countOne++;  
            } else if (input.substring(i, i + 3).equals("IOI")) {
                countTwo++;  
            }
        }
        
        System.out.println(countOne);  
        System.out.println(countTwo);  
    }
    
}