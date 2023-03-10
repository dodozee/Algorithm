import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
public class Main { //가천대 화이팅!!!! //퀵정렬로함!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> sortList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			sortList.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(sortList);
		
		for(int value : sortList) {
			sb.append(value+"\n");
		}
		System.out.println(sb);
	}
}