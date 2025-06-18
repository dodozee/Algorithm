import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	static int N;
	static int[] nums;
	static ArrayList<ArrayList<Integer>> edge = new ArrayList<ArrayList<Integer>>();
	static boolean[] check;
 	public static void main(String arg[]) throws Exception {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		N = Integer.parseInt(br.readLine());
 		nums = new int[N];
 		
 		
 		for(int i = 0; i < N; i++) {
 			edge.add(new ArrayList<Integer>());
 			nums[i] = 1; //재료 기본
 		}
 		
 		for(int i = 0; i < N-1; i++) {
 			int a,b;
 			int p,q;
 			String[] temp = br.readLine().split(" ");
 			a = Integer.parseInt(temp[0]);
 			b = Integer.parseInt(temp[1]);
 			p = Integer.parseInt(temp[2]);
 			q = Integer.parseInt(temp[3]);
 			int ggcd = gcd(p,q); //6 4 = 3 2
 			calc(a,b, p/ggcd, q/ggcd);
 		}
 		
 		int regcd = gcd(nums[0], nums[1]);
 		for(int i = 0; i < N; i++) {
 			regcd = gcd(regcd, nums[i]);
 		}
 		for(int i = 0; i < N; i++) {
 			nums[i] /= regcd;
 		}
 		for(int i = 0; i < N-1; i++) {
 			System.out.print(nums[i] + " ");
 		}
 		System.out.println(nums[N-1]);
 	}
 	static void calc(int a, int b, int p, int q) {
 		check = new boolean[N];
 		int tempA = nums[a];
 		int tempB = nums[b];
 		update(a, tempB * p);
 		update(b, tempA * q);
 		edge.get(a).add(b);
 		edge.get(b).add(a);
 	}
 	static int gcd(int a, int b) {
 		int r = a % b;
 		if(r == 0)
 			return b;
 		return gcd(b, r);
 	}
 	static void update(int target, int num) {
 		nums[target] *= num;// 1 * 1 1 * 3
 		check[target] = true;
 		for(int i = 0; i < edge.get(target).size(); i++) {
 			if(check[edge.get(target).get(i)] != false)
 				continue;
 			update(edge.get(target).get(i), num);
 		}
 	}
}