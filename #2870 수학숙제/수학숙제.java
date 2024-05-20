import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<String> ans = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("\\d+");
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			String string = br.readLine();
			Matcher matcher = pattern.matcher(string);
			
			while(matcher.find()) {
				String num = matcher.group().replaceAll("^0+", "");
				ans.add(num.length() == 0 ? "0" : num);
			}
		}
		
		ans.sort((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
		for(String s : ans)
			sb.append(s).append('\n');
		
		System.out.println(sb);
		
	}

}