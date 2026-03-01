import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt(), y = sc.nextInt();
        int z = (int) (y * 100 / x);
        int ans = -1;

        if (z < 99) {
            ans = (int) Math.ceil((100 * y - x * (z + 1)) / (double) (z - 99));
        }

        System.out.println(ans);

    }
}