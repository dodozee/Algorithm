import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int result = 0;
        String[] input = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(input[i]);

            if (number > max) {
                if (max > Integer.MIN_VALUE) {
                    queue.offer(max);
                }
                max = number;
            } else {
                queue.offer(number);
            }
        }

        while (!queue.isEmpty()) {
            result += (max + queue.poll());
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}