import java.io.*;

public class Main {//박두지 화이팅!!!
    public static boolean[] isPrime = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getPrimes();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            int count = 0;

            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isPrime[i])
                    count++;
            }
            System.out.println(count);
        }
    }

    public static void getPrimes() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i])
                continue;
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }
}
