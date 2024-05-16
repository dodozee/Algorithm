import java.io.*;
import java.util.*;
 
 
public class Main {
	static boolean[] prime;
    
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
       
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		prime = new boolean[N + 1];
		getPrime();
		
		
		for(int i = M; i <= N; i++) {
			if(!prime[i]) sb.append(i).append('\n');
		}
		System.out.println(sb.toString());
	}
 
	 private static void getPrime() {
         
		prime[0] = true;
        prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) {
                continue;
            }
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
 