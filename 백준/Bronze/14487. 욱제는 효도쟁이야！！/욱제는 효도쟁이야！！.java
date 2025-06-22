import java.util.Scanner;
import java.util.Arrays;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        
        Arrays.sort(numbers);
        
        long sum = 0;
        
        for (int i = 0; i < n - 1; i++) {
            sum += numbers[i];
        }
        
        System.out.println(sum);
    }
    
}