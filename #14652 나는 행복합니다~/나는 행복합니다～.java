import java.io.*;
import java.util.StringTokenizer;

public class Main {//박두지 화이팅!!
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int count = 0;
        
        for(int i=0;i<r;i++) {
        	for(int j=0;j<c;j++) {
        	    if(m==count) {
                        bw.write(i+" "+j);
                        bw.flush();
                    }
                    count++;
        	}
        }
    }
}