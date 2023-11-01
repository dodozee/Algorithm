import java.io.*;
import java.util.*;
public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        StringBuilder builder = new StringBuilder();
        while (st.hasMoreTokens()) {
            builder.append(st.nextToken().charAt(0));
        }
        System.out.print(builder);
    }
}