import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
        
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			if(arr[i].contains("X") == false) {
				cnt++;
			}
		}
		int maximum = cnt;
		cnt = 0;
		
		for(int i = 0; i < M; i++) {
			int cnts = 0;
			for(int j = 0; j < N; j++) {
				if(arr[j].charAt(i) == '.') {
					cnts++;
				}
			}
			if(cnts == N) cnt++;
		}
		maximum = Math.max(maximum, cnt);
		System.out.println(maximum);
	}

}