import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] input = sc.next().split(":");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int gcdResult = gcd(n, m);
        
        System.out.println(n / gcdResult + ":" + m / gcdResult);
    }
    
    private static int gcd(int n, int m) {
        while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }
}