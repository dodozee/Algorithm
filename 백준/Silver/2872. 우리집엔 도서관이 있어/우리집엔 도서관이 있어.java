import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] books;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		books = new int[n];
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			books[i] = num;
		}
		
		int start = 1;
		int sum = 0;
		if(n <= 1) {
			System.out.println(0);
		}
		else {
			if(books[0] > 1) {
				sum += books[0] - 1;
				start = books[0];
			}
			
			for(int i = 1; i < n; i++) {
				if(start + 1 < books[i]) {
					sum += books[i] - start;
					start = books[i];
				}
				
				if(start + 1 == books[i]) {
					start = books[i];
				}
			}
			
			System.out.println(sum);
		}
	}
}