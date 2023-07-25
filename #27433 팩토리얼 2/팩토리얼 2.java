import java.math.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= N; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);
    }
}
