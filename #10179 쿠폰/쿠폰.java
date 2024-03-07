import java.io.*;

public class Main { //박두지 화이팅!!!
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			double money = Double.parseDouble(br.readLine());
			money *= 0.8;
			
			System.out.println("$" + String.format("%.2f", money));
		}
	}
}