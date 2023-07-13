import java.io.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            a[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (a[i] > a[i - j * j] + 1) {
                    a[i] = a[i - j * j] + 1;
                }
            }
        }
        System.out.println(a[N]);
    }
}