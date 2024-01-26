
import java.io.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean prime[] = new boolean[1000001];
        prime[0] = prime[1] = true; 
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }

        }

        int n = Integer.parseInt(br.readLine());

        while (n != 0) {
            boolean isProved = false;
            for (int i = 2; i <= n / 2; i++) {
                if (!prime[i] && !prime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    isProved = true;
                    break;
                }
            }

            if (!isProved) {
                System.out.println("Goldbach's conjecture is wrong.");
            }

            n = Integer.parseInt(br.readLine());

        }

    }
}