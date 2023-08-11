import java.io.IOException;
import java.util.Scanner;

public class Main {//박두지 화이팅!!
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					System.out.print(":" + s + ":");
				} else {
					System.out.print(":fan:");
				}
			}
			System.out.println();
		}

	}
}