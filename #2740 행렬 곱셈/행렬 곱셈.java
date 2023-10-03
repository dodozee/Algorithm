import java.io.*;
import java.util.*;
 
public class Main {//박두지 화이팅!!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		st = new StringTokenizer(br.readLine(), " ");
		
		// B행렬 입력 
		st.nextToken();	
		int k = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[m][k];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < k; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		// 행렬 계산 및 출력
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				int sum = 0;
				for(int g = 0; g < m; g++) {
					sum += A[i][g] * B[g][j];
				}
				sb.append(sum).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}