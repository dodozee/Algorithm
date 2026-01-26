import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			String a = bf.readLine();

			ArrayList<Integer> list = new ArrayList<>();
			int idx = -1;
			int num = -1;

			for (int j = a.length() - 1; j >= 0; j--) {
				list.add(a.charAt(j) - '0');

				Collections.sort(list, Collections.reverseOrder());
				if (list.get(0) != a.charAt(j) - '0') {
					idx = j;
					for (int k = list.size() - 1; k >= 0; k--) {
						if (a.charAt(j) - '0' < list.get(k)) {
							num = list.get(k);
							break;
						}
					}
					break;
				}
			}

			if (idx == -1) {
				bw.write("BIGGEST\n");
			} else {
				String result = a.substring(0, idx);
				result += num;
				boolean flag = false;
				Collections.sort(list);
				for (int j = 0; j < list.size(); j++) {
					if (!flag && list.get(j) == num) {
						flag = true;
						continue;
					}
					result += list.get(j);
				}
				bw.write(result + "\n");
			}
		}
		bw.flush();
	}
}