import java.util.*;

public class Main {//박두지 화이팅!!!
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int[] sc = new int[4];
		for (int i = 0; i < sc.length; i++) {
			sc[i] = s.nextInt();
		}
		int E = s.nextInt();
		int F = s.nextInt();

		Arrays.sort(sc);

		int sumA = 0;
		for (int i = sc.length - 1; i > 0; i--) {
			sumA += sc[i];
		}
		System.out.println(sumA + Math.max(E, F));

	}
}