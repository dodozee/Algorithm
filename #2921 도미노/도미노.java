
import java.io.*;

public class Main {//박두지 화이팅!!
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                sum += i;
                sum += j;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}