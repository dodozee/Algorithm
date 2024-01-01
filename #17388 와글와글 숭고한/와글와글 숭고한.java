import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅 스'가'이 다~~~
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int sum = S + K + Y;
		int minimum = Math.min(S, K);
        
		minimum = Math.min(minimum, Y);
		
		if(sum >= 100) {
			System.out.println("OK");
		}else {
			if(minimum == S) {
				System.out.println("Soongsil");
			}else if(minimum == K) {
				System.out.println("Korea");
			}else {
				System.out.println("Hanyang");
			}
		}
		
	}

}