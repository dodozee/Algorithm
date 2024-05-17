import java.io.*;
 
public class Main {
 
	static long[] seqence = new long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		padovan();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			sb.append(seqence[Integer.parseInt(br.readLine())]).append('\n');
		}
		
		System.out.println(sb);
	}
 
	public static void padovan() {
		
		seqence[1] = 1;
		seqence[2] = 1;
		seqence[3] = 1;
 
		for (int f = 4; f < 101; f++) {
			seqence[f] = seqence[f - 2] + seqence[f - 3];
		}
	}
 
}