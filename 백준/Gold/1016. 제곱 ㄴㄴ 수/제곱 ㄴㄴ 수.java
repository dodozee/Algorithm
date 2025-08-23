import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long s = Long.parseLong(st.nextToken());
		long e = Long.parseLong(st.nextToken());
		
		long count = e-s+1;
		boolean[] check = new boolean[(int)count];
		
		for(long i=2; i*i<=e; i++) {
			long pow = i*i; 
			long tmp = s/pow;  
			if(s%pow != 0) { 
				tmp += 1;
			}
			
			for(long j = tmp; j*pow<=e; j++) {
				int canSqrt = (int)(j*pow-s);
				if(!check[canSqrt]) {
					check[canSqrt] = true; 
					count--;
				}
			}
		}
		System.out.println(count);
	}
}

