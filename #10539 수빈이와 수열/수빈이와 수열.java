import java.io.*;
import java.util.Scanner;

public class Main {//
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int arrSize = sc.nextInt();
		int[] A = new int[arrSize];
		int[] B = new int[arrSize];

		for (int i = 0; i < B.length; i++) {
			B[i] = sc.nextInt();
		}

		int sum = 0;

		for (int i = 0; i < B.length; i++) {
			A[i] = B[i] * (i + 1) - sum;
			sum += A[i];
		}

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		sc.close();
	}
}