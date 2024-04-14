 
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int array[] = new int[N];

		st = new StringTokenizer(br.readLine());
        
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
        
		Arrays.sort(array);
		for (int i = 0; i < N; i++) {
			if(array[i]>L) {
				break;
			}
			L++;
		}
		
		System.out.println(L);
	}
}
 

