import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 친구 수
        int m = Integer.parseInt(st.nextToken()); 
        int l = Integer.parseInt(st.nextToken()); //

        int[] arr = new int[n + 1]; 
        int num = 1; 
        int count = 0; 
        while (true) {
            arr[num]++;

            if (arr[num] == m) {
                break;
            }

            if (arr[num] % 2 == 1) { 
                num += l;
                if (num > n) {
                    num -= n;
                }
            } else { 
                num -= l;
                if (num <= 0) {
                    num += n;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}