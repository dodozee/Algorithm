import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int T = Integer.parseInt(s.nextLine());
		
		for(int i=1; i<=T; i++) {
			int A = s.nextInt();
			int B = s.nextInt();
			System.out.println(A+B);			
		}

	}
}