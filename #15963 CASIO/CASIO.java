import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		if(N == M) {
            System.out.println(1);}
		else {
            System.out.println(0);
        }
	}

}