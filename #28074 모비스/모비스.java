import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		int M = 0;
		int O = 0;
		int B = 0;
		int I = 0;
		int S = 0;
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == 'M') {
				M = 1;
			}else if(a.charAt(i) == 'O') {
				O = 1;
			}else if(a.charAt(i) == 'B') {
				B = 1;
			}else if(a.charAt(i) == 'I') {
				I = 1;
			}else if(a.charAt(i) == 'S') {
				S = 1;
			}
		}
		
		if(M == 1 && O == 1 && B == 1 && I == 1 && S == 1) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}