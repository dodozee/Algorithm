import java.io.*;
import java.util.StringTokenizer;

public class Main {//박두지 화이팅!!
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if((A + B) % 2 != 0 || A < B) {
			System.out.println(-1);
		}else {
			System.out.println(((A + B) / 2) + " " + (((A + B) / 2) - B));
		}
	}

}