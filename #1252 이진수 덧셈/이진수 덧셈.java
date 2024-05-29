import java.io.*;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		
		BigInteger ABinary = new BigInteger(A, 2);
		BigInteger BBinary = new BigInteger(B, 2);
		
		BigInteger s = ABinary.add(BBinary);
		
		String sumBinary = s.toString(2);
		
		System.out.println(sumBinary);
	}

}