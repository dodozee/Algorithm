import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int result = (W / L) * (H / L);
		
		if(result>= N) {
			System.out.println(N);
		}else {
			System.out.println(result);
		}
		
	}

}