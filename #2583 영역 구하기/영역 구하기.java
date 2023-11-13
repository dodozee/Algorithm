import java.util.*;
import java.io.*;

public class Main {//박두지 화이팅!!
	
	static int M, N, K;
	static int[][] field;
	static int size;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static ArrayList<Integer> result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
		field = new int[M][N]; 
		result = new ArrayList<>();
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int y=y1;y<y2;y++) {
				for(int x=x1;x<x2;x++) {
					field[y][x] = 1; 
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(field[i][j] == 0) {
					size=1;
					DFS(i, j);
					result.add(size);
				}
			}
		}
		
		Collections.sort(result);
		
	
		
		sb.append(result.size()+"\n");
		for(int r : result) {
			sb.append(r+" ");
		}
		System.out.println(sb.toString());
		
	}
	
	public static void DFS(int y, int x) {
		field[y][x] = 1; 
		
		for(int i=0;i<4;i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx>=0 && ny >=0 && nx<N && ny<M && field[ny][nx]==0) {
				size++;
				DFS(ny,nx);
			}
		}
	}
}
