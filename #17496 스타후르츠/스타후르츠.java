import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int C = sc.nextInt();
        int P = sc.nextInt();
        System.out.println((n-1) / T * C * P);
    }
}