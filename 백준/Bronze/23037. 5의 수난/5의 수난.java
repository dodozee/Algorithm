import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int sum = sumOfFifthPowers(n);
        
        System.out.println(sum);
    }
    
    public static int sumOfFifthPowers(int num) {
        int sum = 0;
        
        while (num > 0) {
            int digit = num % 10;
            
            sum += Math.pow(digit, 5);
            
            num /= 10;
        }
        
        return sum;
    }
}