import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int DP[][];
	static boolean classRoom[][];
	static int N,M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			DP = new int[N+1][1<<M];
			classRoom = new boolean[N+1][M];
			for(int n=1; n<=N; n++){
				String input = br.readLine();
				for(int m=0; m<M; m++){
					if(input.substring(m,m+1).equals("x")) {
						classRoom[n][m] = true;
					}
				}
			}
			solve();
		}
		

	}
	
	static void solve() {
			
		int ans = 0;
		List<SeatCount> bits_set = new ArrayList<SeatCount>();
		for(int bit=0; bit < (1<<M); bit++){
			if(adj_check(bit)){
				int cnt = 0;
				for(int i=0; i<M; i++){
					int check = (1<<i);
					if(((1<<i) & bit) >= 1) cnt++;
				}
				bits_set.add(new SeatCount(bit, cnt));
			}	
		}
		
		for(int i=1; i<=N; i++) {
			for(SeatCount bit : bits_set){
				if(!seat_check(i, bit.seatBit)){
					continue;
				}
				for(SeatCount fbit : bits_set){
					if(bits_check(bit.seatBit, fbit.seatBit)){
						DP[i][bit.seatBit] = Math.max(DP[i][bit.seatBit], DP[i-1][fbit.seatBit]+bit.count);
						ans = Math.max(ans, DP[i][bit.seatBit]);
					}
				}
			}
		}
		System.out.println(ans);
			
	}
	
	//인접한 자리인지 체크
	static boolean adj_check(int bit){
		for(int i=0; i<M-1; i++){
			int val = (3<<i); // 3이 비트로 나타내면 11이니까 붙어있는 자리를 나타냄
			if((bit & val)==val) {
				return false;
			}	
		}
		return true;
	}
	
	
	static boolean bits_check(int bit, int fbit){
		for(int i=0; i<M; i++){
			if(((1<<i) & fbit) >= 1) {
				if(i>0 && ( ((1<<(i-1)) & bit) >= 1)) return false;
				if(((1 << (i+1)) & bit) >=1) return false;		
			}
		}
		return true;
	}
	
	static boolean seat_check(int n, int bit) {
		for(int i=0; i<classRoom[n].length; i++){
			if(classRoom[n][i] && (bit & (1<<i)) >= 1) return false;
		}
		return true;
	}
	
}


class SeatCount{
	int seatBit;
	int count;
	
	public SeatCount(int s, int c){
		this.seatBit = s;
		this.count = c;
	}
}

