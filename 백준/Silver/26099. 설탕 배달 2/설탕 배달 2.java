import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    BufferedReader br;
    BufferedWriter bw;

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        bw = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));

        long n = Long.parseLong(br.readLine());
        long res = n / 5;
        long r = n % 5;

        if (res == 0 && r == 4 || res < 2 && r == 2) {
            res = -1;
        } else {
            res += r / 3;
            r %= 3;
            while (r > 0) {
                res += 1;
                r -= 1;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}