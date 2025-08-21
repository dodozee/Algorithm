import java.util.*;
import java.io.*;
public class Main{

	static int n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000001];
		
		for(int i=0; i<n; i++) {
		
		 st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		arr[len]=v;
		}
		
		int l = 0;
		int r = 2*k+1;
		
		if(r>1000000) {r=1000001;}
		
		int sum =0;
		for(int i=l; i<r; i++) {
			sum+=arr[i]; 
		}
		
		int max = sum;
		for(int i=0; i+2*k+1<=1000000; i++) {
			
			sum-=arr[i]; 
			sum+=arr[i+2*k+1]; 
			
			max = Math.max(sum, max);
			
		}
		System.out.println(max);
	}
	
	
}