import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger P = new BigInteger(st.nextToken());
		BigInteger K = new BigInteger(st.nextToken());
		BigInteger i = new BigInteger("1");
		
		while(true) {
			if(i.compareTo(K) == 1 || i.compareTo(K) == 0) {
				System.out.println("GOOD");
				break;
			}
			i = i.add(BigInteger.ONE);
			
			if(P.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(K) == -1) {
				System.out.println("BAD " + i);
				break;
			}
		}
		
	}

}
