import java.util.*;
import java.io.*;
 
public class Main {//박두지 화이팅~~
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			int P = Integer.parseInt(st.nextToken());
			st.nextToken();			
			int O = Integer.parseInt(st.nextToken());
 
			if (O % P == 0) {
				sb.append((P * 100) + (O / P)).append('\n');
 
			} else {
				sb.append(((O % P) * 100) + ((O / P) + 1)).append('\n');
			}
		}
		System.out.print(sb);
 
	}
}