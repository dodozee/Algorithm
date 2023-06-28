import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		int min = 10000;
		
		int square[] = new int[101];
		for(int i = 1;i<=100;i++) {
			square[i] = i * i;
			if(square[i] >= M && square[i] <= N) {
				sum += square[i];
				if(square[i] < min) {
					min = square[i];
				 }
			 }
		}
		if(sum == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}