import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger one = new BigInteger(br.readLine());
        String op = br.readLine();
        BigInteger two = new BigInteger(br.readLine());
        if (op.equals("*")) {
            System.out.print(one.multiply(two));
        } else {
            System.out.print(one.add(two));
        }
    }
}