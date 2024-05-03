import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String s = "";
        while ((s=br.readLine()) != null) {
            BigInteger n = new BigInteger(s);
            BigInteger base = BigInteger.ZERO;
            while(true) {
                base = base.multiply(BigInteger.TEN).add(BigInteger.ONE);
                if (base.mod(n).equals(BigInteger.ZERO)) {
                    result.append(base.toString().length()).append('\n');
                    break;
                }
            }
        }
        System.out.print(result);
    }
}