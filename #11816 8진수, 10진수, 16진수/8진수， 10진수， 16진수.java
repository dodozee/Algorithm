import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int radix = 10;
        
        String input = br.readLine();
        if (input.startsWith("0x")) {
            input = input.substring(2);
            radix = 16;
        } else if (input.startsWith("0")) {
            input = input.substring(1);
            radix = 8;
        }
        
        System.out.print(new BigInteger(input, radix).toString());
    }

}
