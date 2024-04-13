import java.io.*;
import java.util.*;

public class Main {

    static boolean[] check;
	static int[][] memo;
	static int[] town;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		
		town = new int[n+1];
		memo = new int[n+1][2];
		check = new boolean[n+1];
		list = new ArrayList[n+1];
        
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
        
		for(int i=1; i<n+1; i++) {
			Arrays.fill(memo[i],-1);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			town[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[b].add(a);
			list[a].add(b);
		}

		System.out.println(Math.max(traversal(1,0), traversal(1,1)+town[1]));
	}
	
	static int traversal(int position, int flag) {
		
		if(list[position].size()==0) return 0;
		if(memo[position][flag] != -1) return memo[position][flag];

		check[position]= true;
		memo[position][flag] = 0; 
		for(int child : list[position]) {
			if(check[child]) continue;
			if(flag ==1 ) { 
				memo[position][flag] +=traversal(child,0);
			}else {  
				memo[position][flag] +=Math.max(traversal(child,1)+town[child], traversal(child,0));
			}
			
		}
		check[position]= false;
		return memo[position][flag];
	}
}
