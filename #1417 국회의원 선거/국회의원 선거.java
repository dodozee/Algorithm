import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());	
		int bin = Integer.parseInt(bf.readLine());	
		int[] arr = new int[N-1];	
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(bf.readLine());
		
		int min = 0;	
		if(N == 1) {	
			System.out.println("0");
			return;
		}
		while(true) {
			Arrays.sort(arr);
			boolean flag = true;
			int last = arr.length-1;	
			
			if(arr[arr.length-1] >= bin ) {
				bin ++;	
				arr[last] --;	
				min ++;		
				flag = false;	
			}
			if(flag)	
				break;
		}
		System.out.println(min);
		bf.close();
	}

}