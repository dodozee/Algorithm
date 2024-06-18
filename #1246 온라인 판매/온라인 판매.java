import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		int max = 0;
        
		Collections.sort(arr);
        
		
		for (int i = 0; i < M; i++) {
			int tmp = arr.get(i);
			int tmpsum = 0;
			
			if(M-i<N) {
				tmpsum = tmp * (M-i);
			}else {
				tmpsum = tmp * N;
			}
			
			if(tmpsum>max) {
				max = tmpsum;
				result = tmp;
			}
		}
		System.out.println(result + " "+ max);
	}
}