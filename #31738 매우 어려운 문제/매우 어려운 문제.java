import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num1 = sc.nextLong();
        long num2 = sc.nextLong();

        System.out.println(getModuler(num1, num2));

    }

    private static long getModuler(long num1, long num2) {
        long result =1;
        if (num1 > num2) {
            return 0;
        } else {
            for (long i = num1; i > 0; i--) {
                result *= i;
                result %= num2;


                if (result == 0) {
                    return 0;
                }
            }
        }
        return result;



    }


}
