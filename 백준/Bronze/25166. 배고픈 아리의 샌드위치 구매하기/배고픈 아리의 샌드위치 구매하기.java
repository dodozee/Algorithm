import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a < 1024) {
            System.out.println("No thanks");
        } else {
            int needMoney = a - 1023;
            if ((needMoney & b) == needMoney) {
                System.out.println("Thanks");

            } else {
                System.out.println("Impossible");

            }
        }

    }
}