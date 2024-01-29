import java.io.*;
import java.math.BigInteger;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger result = new BigInteger("1");
        try {
            for (String a : br.readLine().split(" ")){
                result = result.multiply(new BigInteger(a));
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}