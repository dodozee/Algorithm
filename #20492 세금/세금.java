import java.io.*;

public class Main {//박두지 화이팅!!!
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int a = (int) (n*0.78);
		int b = (int) (n*0.8 + (n*0.2)*0.78);
		System.out.println(a);
		System.out.println(b);

	}

}