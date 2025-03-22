import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); 
		
		int count = 8;
		
		for (int i = 1; ; i++) {
			if (n - Math.pow(2, i) == 0) {
				count = count + i + 2; 
				break;
			} else if (n - Math.pow(2, i) < 0) {
				count = count + i + 1; 
				break;
			}
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
