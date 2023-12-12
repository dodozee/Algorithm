import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
	static int M,N;
	static String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ArrayList<Words> arrList = new ArrayList<>();
		
		for (int i = M; i <= N; i++) {
			String tmp = Integer.toString(i);
			char[] nums = tmp.toCharArray();
			tmp="";
			for (int j = 0; j < nums.length; j++) {
				tmp+=word[nums[j]-'0'];
			}
			arrList.add(new Words(i, tmp));
		}
		
		Collections.sort(arrList);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arrList.size(); i++) {
			sb.append(arrList.get(i).number+" ");
			if((i+1)%10==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static class Words implements Comparable<Words>{
		int number;
		String word;
		public Words(int number, String word) {
			super();
			this.number = number;
			this.word = word;
		}
		@Override
		public int compareTo(Words o) {
			return this.word.compareTo(o.word);
		}
		
	}
}