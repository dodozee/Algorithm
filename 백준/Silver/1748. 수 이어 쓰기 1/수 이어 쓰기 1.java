import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int plus = 1;
        int num = 10;
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (i % num == 0) {
                plus++;
                num *= 10;
            }
            result += plus;
        }

        System.out.println(result);


    }

}

