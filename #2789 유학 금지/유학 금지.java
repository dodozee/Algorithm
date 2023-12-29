import java.io.*;

public class Main {//박두지 화이팅!!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] words = "CAMBRIDGE".toCharArray();
		String input = br.readLine();

		for (int i = 0; i < words.length; i++) {
            
			if (input.indexOf(words[i]) > -1) {
				input = input.replace(String.valueOf(words[i]), "");
			}
            
		}
		System.out.println(input);
	}
}