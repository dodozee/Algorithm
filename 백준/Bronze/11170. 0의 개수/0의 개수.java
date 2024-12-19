import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            
            int cnt = 0;

            for (int j = N; j <= M; j++) {
                int t = j;
                if (t == 0) {
                    cnt ++;
                    continue;
                }
                while (t > 1) {
                    if (t % 10 == 0) {
                        cnt++;
                    }
                    t /= 10;
                }
            }
            System.out.println(cnt);
        }
    }
}