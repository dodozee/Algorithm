import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int Acnt = 100;
		int Bcnt = 100;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A > B) {
				Bcnt -= A;
			}else if(A < B) {
				Acnt -= B;
			}
		}
		System.out.println(Acnt + "\n" + Bcnt);
	}
}