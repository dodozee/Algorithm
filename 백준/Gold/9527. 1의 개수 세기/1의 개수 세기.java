import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A, B;
        A = sc.nextLong();
        B = sc.nextLong();
        System.out.println(getOnes(B
                                   , binLength(B)) - getOnes(--A, binLength(A > 0 ? A : 1)));
    }

    static long getOnes(long num, int x) {
        if (x == 1) return num == 1 ? 1 : 0;

        long msb = (1L << x - 1) & num;
        long t = num - msb;
        long b = num >> (x - 1);

        return b * ((x - 1) * (1L << x - 2) + t + 1) + getOnes(t, x - 1);
    }

    static int binLength(long n) {
        int result = 0;
        while (n > 0) {
            n >>= 1;
            result++;
        }
        return result;
    }
}
