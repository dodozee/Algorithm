import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		} //end input
		
		int max=0;
		for(int tmp=0,size=(1<<(N*M));tmp<size;tmp++) { 
			
			int sum=0; 
			int order;
			for(int i=0;i<N;i++) {
				order=1;
				for(int j=M-1;j>=0;j--) {
					int num=j+i*M;
					if((tmp&(1<<num))>0) {
						sum += (map[i][j]*order); 
						order*=10;
					} else { 
						order=1;
					}
				}
			}
			for(int j=0;j<M;j++) {
				order=1;
				for(int i=N-1;i>=0;i--) {
					int num = j+i*M;
					if((tmp&(1<<num))==0) {
						sum += (map[i][j]*order);
						order*=10;
					} else {
						order=1;
					}
				}
			}
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}