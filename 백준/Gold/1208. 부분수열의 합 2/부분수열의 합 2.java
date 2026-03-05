import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = n/2;
		int[] a = new int[1<<(n-size)];
		int[] b = new int[1<<(size)];
		for(int i=0; i<(1<<n-size); i++) {
			for(int j=0; j<n-size; j++) {
				if((i&(1<<j))==(1<<j)) {
					a[i] +=arr[j];
				}
			}
		}
		for(int i=0; i<(1<<size); i++) {
			for(int j=0; j<size; j++) {
				if((i&(1<<j))==(1<<j)) {
					b[i]+= arr[j+(n-size)];
				}
			}
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int ap =0;
		int bp = b.length-1;
		long cnt = 0;
		while(ap<a.length && bp>-1){
			int av = a[ap], bv = b[bp];
			if(av+bv==s) {
				long ac=0, bc=0;
				while(ap<a.length && av == a[ap]) {
					ac++;
					ap++;
				}
				
				while(bp>-1&& bv == b[bp]) {
					bc++;
					bp--;
				}
				cnt += ac*bc;
			}
			
			if(av+bv < s) {
				ap++;
			}else if(av+bv>s) {
				bp--;
			}
		}
		if(s==0) cnt--;
		System.out.println(cnt);
	}
}