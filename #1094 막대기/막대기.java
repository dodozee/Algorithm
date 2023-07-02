import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int count = 0;

        while (X > 0) {
            if (X >= 64) {
                X -= 64;
                count++;
            } else if (X >= 32) {
                X -= 32;
                count++;
            } else if (X >= 16) {
                X -= 16;
                count++;
            } else if (X >= 8) {
                X -= 8;
                count++;
            } else if (X >= 4) {
                X -= 4;
                count++;
            } else if (X >= 2) {
                X -= 2;
                count++;
            } else {
                X -= 1;
                count++;
            }
        }

        System.out.println(count);
    }
}
