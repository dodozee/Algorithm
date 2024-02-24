import java.io.*;

public class Main {//park doozee fighting
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++) { 
			int n = Integer.parseInt(br.readLine()); 

			int index = 0; 

			while(n > 0) { 
				if(n%2 == 1) { 
					System.out.print(index + " "); 
				}
				n/=2; 
				index++; 
			}
			System.out.println(); 
		}
	}
}