import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int odd = 0;
        int even = 0;

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (n % 2 == 0) {
            bw.write(odd == even ? "1" : "0");
            bw.flush();
        } else {
            bw.write(odd - even == 1 ? "1" : "0");
            bw.flush();
            
        }
    }
}
    
    
    
