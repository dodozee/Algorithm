import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> tower;
	static int n, a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();

		tower = new ArrayList<>();

		if (a + b > n + 1) {
			System.out.print(-1);
			return;
		}

		for (int i = 1; i < a; i++) {
			tower.add(i);
		}
		tower.add(Math.max(a, b));

		for (int i = b - 1; i >= 1; i--) {
			tower.add(i);
		}

		if (a == 1) {
			while (tower.size() < n) {
				tower.add(1, 1);
			}
		} else {
			while (tower.size() < n) {
				tower.add(0, 1);
			}
		}
		for (int i : tower) {
			System.out.print(i + " ");
		}
	}
}