import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		System.out.print(Math.min(n, Integer.parseInt(st.nextToken()) / 2 + Integer.parseInt(st.nextToken())));
	}
}