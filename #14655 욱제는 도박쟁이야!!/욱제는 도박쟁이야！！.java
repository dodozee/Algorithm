import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(bf.readLine());
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		
		int[] arr1 = new int[cnt];
		int[] arr2 = new int[cnt];
		int result = 0;
		
		for(int i = 0; i < cnt; i++) {
			arr1[i] = Math.abs(Integer.parseInt(st1.nextToken()));
			arr2[i] = Math.abs(Integer.parseInt(st2.nextToken()));
			
			result += arr1[i] + arr2[i];
		}
		System.out.println(result);
	}

}