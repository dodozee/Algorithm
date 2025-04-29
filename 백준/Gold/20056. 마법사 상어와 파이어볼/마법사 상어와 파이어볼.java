import java.util.*;
import java.io.*;

public class Main{
	static int map[][][];
	static Queue<Integer[]> fireball =new LinkedList<>();
	static int dy[] = {-1,-1,0,1,1,1,0,-1};
	static int dx[] = {0,1,1,1,0,-1,-1,-1};
	static Queue<Integer> direction[][];
	public static void main(String[] args) throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());

		map = new int[N][N][3];
		
		direction=new LinkedList[N][N];
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				direction[i][j]=new LinkedList<>();
			}
		}

		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			fireball.add(new Integer[] {r-1,c-1,m,s,d});
		}

		for(int i=0;i<K;i++) {
			moveFireball();
			replaceFireball();
		}

		int sum = countFireball();


		System.out.println(sum);


	}
	
	public static void moveFireball() {
		
		while(!fireball.isEmpty()) {
			Integer temp[]= fireball.poll();
			int r = temp[0];
			int c = temp[1];
			int m = temp[2];
			int s = temp[3];
			int d = temp[4];
			
			r += (dy[d] * s);
			c += (dx[d] * s);
			r%=map.length;
			c%=map.length;
			
			if(r<0) {
				r = Math.abs(r);
				r = map.length - r;
			}
			if(c<0) {
				c=Math.abs(c);
				c=map.length - c;
			}
			
			map[r][c][0] += 1; 
			map[r][c][1] += m; 
			map[r][c][2] += s; 


		
			direction[r][c].add(d);

		}


	}
	public static void replaceFireball() {

		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				int sum = map[i][j][0];  
				int m = map[i][j][1]; 
				int s = map[i][j][2];
		
				if(map[i][j][0]==1) {
					int now = direction[i][j].poll();
					fireball.add(new Integer[] {i,j,m,s,now});
				}
				
				else if(map[i][j][0]>1) {
					int newM = m / 5;
					int newS= s / sum ;
					
					int dir[]= {0,2,4,6};
					boolean findOdd= false;
					boolean findEven=false;
				
					while(!direction[i][j].isEmpty()) {
						int poll=direction[i][j].poll();
						if(poll%2==0) findEven = true;
						else findOdd = true;
					}
					
					if(findOdd==true&&findEven==true) {
						dir[0] = 1;
						dir[1] = 3;
						dir[2] = 5;
						dir[3] = 7;
					}

					if(newM!= 0) {
						for(int k=0;k<4;k++) {
							fireball.add(new Integer[] {i,j,newM,newS,dir[k]});
						}

					}
					

				}

				map[i][j][0] = 0;
				map[i][j][1] = 0;
				map[i][j][2] = 0;
			
				
			}
		}

	}
	public static int countFireball() {

		int sum = 0;
		while(!fireball.isEmpty()) {
			Integer temp[]= fireball.poll();
			sum += temp[2];
		}

		return sum;
	}

}

