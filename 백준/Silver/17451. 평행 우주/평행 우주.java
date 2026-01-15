import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] planet = new long[count];
        for (int i = 0; i < count; i++) {
            planet[i] = Long.parseLong(input[i]);
        }

        long speed = Long.MIN_VALUE;
        for (int i = planet.length - 1; i >= 0; i--) {
            if (planet[i] > speed) {
                speed = planet[i];
            } else if (planet[i] < speed) {
                if (speed % planet[i] == 0)
                    continue;
                else {
                    speed = ((speed / planet[i]) + 1) * planet[i];
                }
            }
        }

        bw.write(speed + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}