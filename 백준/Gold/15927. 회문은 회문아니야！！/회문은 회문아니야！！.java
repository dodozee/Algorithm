import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		
		boolean flag = false;
		int len = s.length();
		for(int i=0; i<len/2; i++) {
			if(s.charAt(i) != s.charAt(len-i-1)) {
				System.out.println(s.length());
				return;
			}else if(s.charAt(i) != s.charAt(i+1)) {
				flag = true;
			}
			
		}
		if(flag) {
			System.out.println(s.length()-1);
		}else {
			System.out.println(-1);
		}
	}
}