import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[100001];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int index=(int) (Double.parseDouble(br.readLine()) * 1000);
            answer[index]++;
        }

        for (int i = 0; i < answer.length; i++) {
            while (answer[i] > 0 && cnt < 7) {
                System.out.printf("%.3f\n", i / 1000.0);
                answer[i]--;
                cnt++;
            }
        }
    }
}