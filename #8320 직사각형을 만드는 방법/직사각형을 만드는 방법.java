import java.io.*;

public class Main {//박두지 화이팅!!!
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=1; i<N+1; i++)
			for(int j=1; j<=i; j++)
				if(i*j <= N)
					cnt++;
		System.out.println(cnt);
	}
}