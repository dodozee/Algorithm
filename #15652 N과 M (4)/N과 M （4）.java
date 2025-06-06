import java.util.*;
 
public class Main {
 
	public static int N;
    static int M;
	public static int[] arr;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();
		arr = new int[M];
 
		dfs(1, 0);
 
	}
 
	public static void dfs(int at, int depth) {
 
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
 
        
		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
		}
 
	}
 
}