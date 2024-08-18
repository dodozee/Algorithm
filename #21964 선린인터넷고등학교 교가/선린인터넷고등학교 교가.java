import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); 
		String s = br.readLine(); 
		
		sb.append(s.substring(n - 5, n)); 
		
		bw.write(sb.toString());
		bw.flush();
	}
}
