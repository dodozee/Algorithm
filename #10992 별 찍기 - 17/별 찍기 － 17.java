import java.util.Scanner;
 
public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("*");
        } else {
            for (int i = 1; i <= n - 1; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
 
                for (int j = 1; j <= (2 * (i - 1)) - 1; j++) {
 
                    System.out.print(" ");
                }
                if (i >= 2) {
                    System.out.print("*");
                }
 
                System.out.println();
            }
            for (int i = 1; i <= 2 * (n) - 1; i++) {
                System.out.print("*");
            }
        }
    }
}