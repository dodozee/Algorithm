import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {

            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int minNum = Math.min(a, b);
            if (minNum == a) {
                while(true) {
                    if (b - a < a)
                        break;
                    b/= 2;
                }

            } else {
                while (true) {
                    if (a - b < b) {
                        break;
                    }
                    a/= 2;
                }

            }

            while (a != b) {
                if (a > b) {
                    a /= 2;
                    if (a == b)
                        break;
                    b /= 2;
                    
                } else {
                    b /= 2;
                    if (a == b) break;
                        a /= 2;
                    
                }
            }

            System.out.println(a * 10);

        }



    }
}