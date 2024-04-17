import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();  
		int[] line = new int[N];  
		int cnt = 0;  
		int n = 0;  
		for (int i = 0; i < line.length; i++) {
			line[i] = scan.nextInt(); 
		}

		for (int i = 0; i < line.length; i++) {
			if (line[i] == n && n == 0) {
				cnt++;
				n = 1;
				continue;
			}
			if (line[i] == n && n == 1) {
				cnt++;
				n = 2;
				continue;
			}
			if (line[i] == n && n == 2) {
				cnt++;
				n = 0;
				continue;
			}

		}

		System.out.println(cnt);

	}
}