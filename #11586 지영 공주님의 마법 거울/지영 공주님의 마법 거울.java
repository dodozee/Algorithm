import java.util.Scanner;

public class Main {
	static int N;
	static char cArr[][];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		cArr = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = scan.next();
			for(int j=0; j<N; j++) {
				cArr[i][j] = str.charAt(j);
			}
		}
		int K = scan.nextInt();
		
		if(K == 1) 
			current();			
		else if(K == 2)
			reverseLeftRight();	
		else
			reverseUpDown();	

	}

	public static void reverseUpDown() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N; j++) {
				
				char temp = cArr[i][j];
				cArr[i][j] = cArr[N-i-1][j];
				cArr[N-i-1][j] = temp;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(cArr[i][j]);
			}
			System.out.println();
		}
	}
    
	public static void current() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(cArr[i][j]);
			}
			System.out.println();
		}
	}

	public static void reverseLeftRight() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N/2; j++) {

				char temp = cArr[i][j];
				cArr[i][j] = cArr[i][N-j-1];
				cArr[i][N-j-1] = temp;
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(cArr[i][j]);
			}
			System.out.println();
		}
	}

}