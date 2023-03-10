import java.io.*;
import java.util.*;

public class Main { //갓천대!!대박나라!!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {

            int num = i;

            while(num != 0) {
                sum = sum + (num % 10);
                num = num / 10;
            }

            if(i + sum == N) {
                result = i;
                break;
            }

            sum = 0;

        }

        System.out.println(result);

    }

}