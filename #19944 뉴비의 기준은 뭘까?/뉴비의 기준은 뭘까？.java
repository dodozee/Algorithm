import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        if (M == 1 || M == 2) {
            System.out.println("NEWBIE!");
        } else if (M <= N) {
            System.out.println("OLDBIE!");
        } else {
            System.out.println("TLE!");
        }

        scanner.close();
    }
}
