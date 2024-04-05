import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int temp = 0;

        while (true) {
            if (N % 5 == 0) {
                cnt += N / 5;
                System.out.println(cnt);
                break;
            }else{
                N -= 2;
                cnt++;
            }

            if (N < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}