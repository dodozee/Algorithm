import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int sum = 0;
		boolean isPrime = false;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				sum += (int) c - 96;
			} else if (c >= 'A' && c <= 'Z') {
				sum += (int) c - 38;
			}
		}

		for (int i = 2; i < sum; i++) {
			if (sum % i == 0) {
				isPrime = true;
				break;
			}
		}

		if (isPrime) {
			bw.write("It is not a prime word.");
		} else if(!isPrime){
			bw.write("It is a prime word.");
		}

		bw.flush();
        bw.close();
	}
}