import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(2);
            return;
        }

        for(int i = n; ; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                return;
            }
        }


    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);

        int count = str.length();

        for (int i = 0; i < count / 2; i++) {
            if (str.charAt(i) != str.charAt(count - i - 1)) {
                return false;
            }
        }


        return true;
    }
}
