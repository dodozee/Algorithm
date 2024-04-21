import java.io.*;
import java.util.*;

public class Main {

	static int[] coin; 
    static int[] DP;
	static int n, k;
    

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);

		coin = new int[n];
		DP = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		DP[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= coin[i])
					DP[j] += DP[j - coin[i]];
			}
		}

		bw.write(DP[k] + "\n");
		bw.flush();
        bw.close();
	}
}