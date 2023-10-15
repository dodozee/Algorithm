import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maximum = 0;
		int sum = 0;
		
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sum = sum - N + M;
			if(maximum < sum) {
				maximum = sum;
			}
		}
		System.out.println(maximum);
		
	}

}