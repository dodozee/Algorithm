import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] lampArray;
    static int bridgeLength;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bridgeLength = Integer.parseInt(br.readLine());

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        lampArray = new int[count]; 
        for (int i = 0; i < lampArray.length; i++) {
            lampArray[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = bridgeLength;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (lightCheck(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean lightCheck(int mid) {
        int prev = 0;

        for (int i = 0; i < lampArray.length; i++) {
            if (lampArray[i] - mid <= prev) {
                prev = lampArray[i] + mid;
            } else {
                return false;
            }
        }

        if (bridgeLength - prev > 0) {
            return false;
        } else {
            return true;
        }
    }
}