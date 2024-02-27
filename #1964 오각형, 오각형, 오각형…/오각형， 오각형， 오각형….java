import java.io.*;

public class Main {//박두지 화이팅!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dot = 7;
		long sum = 5;
		
		for(int i = 1; i < N; i++) {
			sum += dot;
			dot += 3;
		}
		System.out.println(sum % 45678);
	}

}