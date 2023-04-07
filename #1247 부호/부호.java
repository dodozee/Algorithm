import java.io.*;
import java.util.*;
import java.math.BigInteger;
	
public class Main {//박두지 화이팅!!! 갓천대 화이팅!!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 3; i++) {
			BigInteger s = new BigInteger("0");
			int n = Integer.parseInt(br.readLine());
			
			for(int j = 0; j < n; j++) {
				BigInteger n2 = new BigInteger(br.readLine());
				s = s.add(n2);
			}
			
            
			if(s.compareTo(BigInteger.ZERO) == 1) {
				System.out.println("+");
			}else if(s.compareTo(BigInteger.ZERO) == -1) {
				System.out.println("-");
			}else System.out.println(0);
			
		}
	}
}


