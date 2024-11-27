import java.io.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr = br.readLine();
		char[] UCPC = {'U', 'C', 'P', 'C'};
		int idx = 0;
		for(int i = 0; i<arr.length(); i++) {
			if(UCPC[idx] == (arr.charAt(i))) {
				idx++;
			}
            
			if(idx == 4) {
				System.out.println("I love UCPC");
				return;
			}
		}
		System.out.println("I hate UCPC");
	}
}