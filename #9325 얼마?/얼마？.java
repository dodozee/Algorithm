import java.io.*;
import java.util.StringTokenizer;

public class Main {//두지 화이팅
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
            
			int result = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int q = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				result += (q * p);
			}
			System.out.println(result);
		}
	}

}