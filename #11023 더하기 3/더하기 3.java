import java.io.*;
import java.util.StringTokenizer;

public class Main {//박두지 화이팅!!!
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = st.countTokens();
		int sum = 0;
		
		for(int i = 0; i < count; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sum);
	}

}