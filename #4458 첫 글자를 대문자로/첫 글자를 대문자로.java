import java.util.*;

public class Main {//박두지 화이팅!!
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = Integer.parseInt(s.nextLine());
		for (int i = 0; i < N; i++) {
			String str = s.nextLine();

			System.out.println((str.charAt(0) + "").toUpperCase() + str.substring(1, str.length()));
		}
	}
}