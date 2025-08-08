import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String str;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while((str=br.readLine())!=null){
			st=new StringTokenizer(str);
			String s=st.nextToken();
			String t=st.nextToken();

			idx=0;
			for(int i=0;i<t.length();i++){
				if(s.charAt(idx)==t.charAt(i)){ 
					idx++;
				}
				if(idx == s.length()) 
					break;
			}

			if(idx==s.length()){
				System.out.println("Yes");
			}

			else{
				System.out.println("No");
			}
		}
	}
}