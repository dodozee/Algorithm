import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] elements, tree, lazy;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		elements = new long[n];
		for(int i=0; i<n; i++) {
			elements[i] = Long.parseLong(br.readLine());
		}
		
		tree = new long[n*4];
		lazy = new long[n*4];
		
		init(0,n-1,1);
		for(int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken())-1;
			if(op==1) {
				long dif = Long.parseLong(st.nextToken());
				update(0,n-1, 1, l, r, dif);
			}else {
				bw.write(pSum(0, n-1, 1, l, r)+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	static long init(int start, int end, int node) {
		if(start == end) return tree[node] = elements[start];
		
		int mid = (start+end)/2;
		return tree[node] =  init(start, mid, node*2) +init(mid+1, end, node*2+1);
	}
	
	static void propagate(int start, int end, int node) {
		if(lazy[node] !=0){
			if(start != end) {
				lazy[node*2] += lazy[node];
				lazy[node*2 +1] += lazy[node];
			}
			tree[node] += lazy[node] * (end-start+1);
			lazy[node]=0;
		}
		
	}
	
	static void update(int start, int end, int node, int left, int right, long dif) {
		propagate(start, end, node);
		if(end < left || right < start) return;
		if(left <= start && end <= right) {
			lazy[node] = dif;
			propagate(start, end, node);
			return;
		}
		
		int mid = (start+end)/2;
		update(start, mid, node*2, left, right, dif);
		update(mid+1, end, node*2+1, left, right, dif);
		
		tree[node] = tree[node*2]+tree[node*2+1];
	}
	
	
	static long pSum(int start, int end, int node, int left, int right) {
		propagate(start, end, node);
		if(end < left || right < start) return 0;
		if(left <= start && end <= right) return tree[node];
		
		int mid = (start+end)/2;
		return pSum(start, mid, node*2, left, right) + pSum(mid+1, end, node*2+1, left, right);
	}
}