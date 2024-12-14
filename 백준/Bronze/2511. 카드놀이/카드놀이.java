import java.io.*;
import java.io.*;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int A = 0;
		int B = 0;
		String winner = "D";
		
		for(int i = 0; i < 10; i++) {
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st2.nextToken());
			
			if(N > M) {
				winner = "A";
				A += 3;
			}else if(N < M) {
				winner = "B";
				B += 3;
			}else {
				A += 1;
				B += 1;
			}
		}
		
		if(A > B) {
			System.out.println(A + " " + B);
			System.out.println("A");
		}else if(A < B) {
			System.out.println(A + " " + B);
			System.out.println("B");
		}else {
			System.out.println(A + " " + B);
			System.out.println(winner);
		}
	}

}

