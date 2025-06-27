import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;

		while ((s = br.readLine()) != null) {
			int size = Integer.parseInt(s) * 10000000;
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];

			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(list);

			int left = 0, right = N - 1;
			boolean flag = false;

			while (left < right) {
				int sum = list[left] + list[right];

				if (sum == size) {
					System.out.printf("yes %d %d\n", list[left], list[right]);
					flag = true;
					break;
				} else if (sum > size) {
					right--;
				} else {
					left++;
				}
			}

			if (!flag) {
				System.out.println("danger");
			}
			
			s = null;
		}
	}
}