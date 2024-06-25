import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); 
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine()); 
		Integer[] D = new Integer[N]; 
		for(int i=0; i<N; i++) {
			D[i] = Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(D, Collections.reverseOrder()); 
		
		int answer = C/A; 
		
		int price = A;
		int kcal = C; 
		for(int i=0; i<N; i++) {
			price += B; 
			kcal += D[i]; 
			int tmp = kcal/price;
			if(answer > tmp) { 
				break;
			}else {
				answer = tmp;
			}
		}
		
		System.out.println(answer);
		
	}
}
