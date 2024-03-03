import java.io.*;
import java.math.BigInteger;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger total = new BigInteger(br.readLine());
        BigInteger dif = new BigInteger(br.readLine());
        BigInteger two = new BigInteger("2");
        
        BigInteger klaudia = (total.subtract(dif)).divide(two).add(dif); 
        BigInteger natalia = (total.subtract(dif)).divide(two);
        
        System.out.println(klaudia);
        System.out.println(natalia);
 
    }
 
}
