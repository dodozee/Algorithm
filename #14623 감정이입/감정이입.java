import java.io.*;

public class Main {//박두지 화이팅
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		
		long A1 = Long.parseLong(A, 2);
		long B1 = Long.parseLong(B, 2);
		
		String sum = Long.toBinaryString(A1 * B1);
		
		System.out.println(sum);
	}

}