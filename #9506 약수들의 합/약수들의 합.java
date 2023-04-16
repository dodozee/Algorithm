import java.util.Scanner;

public class Main {//박두지 화이팅!!! 갓천대 화이팅!!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n;

        while (true) {
            n = sc.nextInt();
            if (n == -1) break;

            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            if (sum == n) {
                sb.append(n).append(" = ");
                for (int i = 1; i < n; i++) {

                    if (n % i == 0) {
                        sb.append(i);
                        if (i != n/2) sb.append(" + ");
                    }
                }

                sb.append("\n");


            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }


        }
        System.out.println(sb);
    }
}