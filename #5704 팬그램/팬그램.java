import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int[] alpabet = new int[26];
			String str = sc.nextLine().replace(" ", "");
			if (str.equals("*"))
				break;
			for (int i = 0; i < str.length(); i++) {
				++alpabet[str.charAt(i) - 97];
			}
			String ret = "Y";
			for (int i = 0; i < alpabet.length; i++) {
				if (alpabet[i] == 0) {
					ret = "N";
					break;
				}
			}
			System.out.println(ret);
		}

	}
}