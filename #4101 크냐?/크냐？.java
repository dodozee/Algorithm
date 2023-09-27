import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            
            if (num1 == 0 && num2 == 0) {
                break;
            }
            
            if (num1 > num2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
        scanner.close();
    }
}
