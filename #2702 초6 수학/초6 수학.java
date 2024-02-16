import java.io.*;
import java.util.StringTokenizer;

public class Main {//박두지 화이팅!!
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
            
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
            
			int maximum = 0;
			int minimum = 0;
			int k = 1;
			
			while(true) {
				if(a % k == 0 && b % k == 0) {
					minimum = k;
				}
				if(k % a == 0 && k % b == 0) {
					maximum = k;
					break;
				}
				k++;
			}
			System.out.println(maximum + " " + minimum);
		}
	}

}