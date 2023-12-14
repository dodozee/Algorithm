import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][3];

		for (int i = 0; i < N; i++) {
            
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] object1, int[] object2) {
				return object2[2] - object1[2];
			}
		});

		int last = 2;
		if (arr[0][0] == arr[1][0]) {
			for (int i = 2; i < N; i++) {
				if (arr[0][0] != arr[i][0]) {
					last = i;
					break;
				}
			}
		}
		System.out.println(arr[0][0] + " " + arr[0][1]);
        
		System.out.println(arr[1][0] + " " + arr[1][1]);
        
		System.out.println(arr[last][0] + " " + arr[last][1]);

	}

}