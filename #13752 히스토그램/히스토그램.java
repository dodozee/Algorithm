import java.util.Scanner;

public class Main {//박두지 화이팅
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            printHistogram(k);
        }

        scanner.close();
    }

    public static void printHistogram(int k) {
        for (int i = 0; i < k; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
