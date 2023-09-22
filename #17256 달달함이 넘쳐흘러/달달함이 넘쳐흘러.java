import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = new int[3];
        int[] c = new int[3];

        for (int i = 0; i < 3; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            c[i] = scanner.nextInt();
        }

        int bX = c[0] - a[2];
        int bY = c[1] / a[1];
        int bZ = c[2] - a[0];

        System.out.println(bX + " " + bY + " " + bZ);

        scanner.close();
    }
}
