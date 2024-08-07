import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		while(true) {
            
			String str = br.readLine();
			if(str.equals("***")) {
				break;
			}
			for(int i=0;i<str.length();i++) {
				sb.append(str.charAt((str.length()-1)-i));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}