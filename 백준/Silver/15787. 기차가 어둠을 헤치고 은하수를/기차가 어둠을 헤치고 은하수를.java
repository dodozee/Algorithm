import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.*;

public class Main {

	static int[] trains;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		trains = new int[N+1];
		
		for(int i=0;i<M;i++) {
			excute(br.readLine());
		}
		
		HashSet<Integer> set = new HashSet<>();
		for(int i=1;i<N+1;i++) {
			set.add(trains[i]);
		}
		
		System.out.println(set.size());
		
	}
	
	public static void excute(String command) {
		StringTokenizer st = new StringTokenizer(command);
		
		int c = Integer.parseInt(st.nextToken());
		int i = Integer.parseInt(st.nextToken());
		int x = -1; 
		
		switch (c){
		case 1:
			x += Integer.parseInt(st.nextToken());
			trains[i] |= (1 << x);
			break;
		case 2:
			x += Integer.parseInt(st.nextToken());
			trains[i] &= ~(1 << x);
			break;
		case 3:
			trains[i] = (trains[i] & ~(1 << 19)) << 1;
			break;
		case 4:
			trains[i] = (trains[i] & ~(1 << 0)) >> 1;
			break;
		}
	}

}