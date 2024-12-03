import java.io.*;
import java.io.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            int n1 = 3 * n;
            int n2 = (n1 % 2) == 0 ? n1 / 2: (n1 + 1) / 2;
            int n3 = 3 * n2;

            int n4 = n3 / 9;



            if (n1 % 2 == 0) {
                System.out.println(num + ". even " + n4);
            } else {
                System.out.println(num + ". odd " + n4);
            }
            num++;

        }

    }
}