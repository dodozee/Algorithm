import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅@!!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		int[] arr1 = new int[4];
		int maximum = -1;
		int N = Integer.parseInt(br.readLine());
        String str1 = "LOVE";
		String str2 = "";
		
		for(int i = 0; i < N; i++) {
			String team = br.readLine();
			
			for(int j = 0; j < 4; j++) {
				int cnt = name.length() - name.replace(String.valueOf(str1.charAt(j)), "").length();
				cnt += team.length() - team.replace(String.valueOf(str1.charAt(j)), "").length();
				arr1[j] = cnt;
				
			}
			
			int tot = 1;
			for(int j = 0; j < 4; j++) {
				for(int k = (j + 1); k < 4; k++) {
					tot *= (arr1[j] + arr1[k]);
				}
			}
			
			if(maximum == (tot % 100) && str2 != "") {
				String[] arr2 = new String[2];
				arr2[0] = str2;
				arr2[1] = team;
				Arrays.sort(arr2);
				str2 = arr2[0];
			}
			
			if(maximum < (tot % 100)) {
				maximum = tot % 100;
				str2 = team;
			}
		}
		
		System.out.println(str2);
	}

}