import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		bfs(map,n);
	}
	
	static void bfs(int[][] map, int n) {
		Queue<int[]> q = new PriorityQueue<>((o1,o2) -> (o1[3]-o2[3]));
		boolean[][] check = new boolean[n][n];
		q.add(new int[] {0,0,0,0});
		check[0][0] = true;
		
		int answer =0;
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int px = p[0], py=p[1];
			int mv = p[2], blackToWhite = p[3];
			if(px==n-1 && py==n-1) {
				answer = blackToWhite;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = px+dx[i];
				int ny = py+dy[i];
				if(nx<0 || ny<0 || nx>n-1 || ny>n-1 || check[ny][nx]) continue;
				check[ny][nx] = true;
				if(map[ny][nx] ==1) {
					q.add(new int[] {nx, ny, mv+1, blackToWhite});
				}
				else{
					q.add(new int[] {nx, ny, mv+1, blackToWhite+1});
				}
			}
		}
		System.out.println(answer);
	}
}