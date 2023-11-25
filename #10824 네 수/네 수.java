import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String a = st.nextToken();
        String b = st.nextToken();
        long A = Long.parseLong(a+b);
        String c = st.nextToken();
        String d = st.nextToken();
        long B = Long.parseLong(c+d);
        System.out.print(A + B);
    }
}