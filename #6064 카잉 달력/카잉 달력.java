import java.util.*;

public class Main { 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int M = s.nextInt(), N = s.nextInt(), x = s.nextInt(), y = s.nextInt();

            int lcm = M * N / gcd(M, N);
            int n = 0;
            int ans = -1;
            while (n * M < lcm) {
                if ((n * M + x - y) % N == 0) {
                    ans = n * M + x;
                    break;
                }
                n++;
            }

            System.out.println(ans);
        }
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
}