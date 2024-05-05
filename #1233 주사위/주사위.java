import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S_1 = Integer.parseInt(st.nextToken());
		int S_2 = Integer.parseInt(st.nextToken());
		int S_3 = Integer.parseInt(st.nextToken());
		int[] arr= new int[(S_1 + S_2 + S_3) - 2];
		
		for(int i = 1; i <= S_1; i++) {
			for(int j = 1; j <= S_2; j++) {
				for(int k = 1; k <= S_3; k++) {
					int sum = i + j + k;
					arr[sum - 3]++;
				}
			}
		}
		
		int max = 0;
		int ans = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				ans = i + 3;
			}
		}
		System.out.println(ans);
	}

}