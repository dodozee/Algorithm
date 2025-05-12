import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[N+1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(func(num,v)+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int func(int x, boolean[] v) {
		int road = x;
		int candi = 0;
		while(road>1) {
			if(v[road]) {
				candi = road; 
			}
			road/=2;
		}
		if(candi == 0) {
			v[x] = true;
			return 0;					
		}else {
			return candi;
		}
	}
	
}