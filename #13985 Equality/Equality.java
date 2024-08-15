import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        String digit = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        String equal = st.nextToken();
        int c = Integer.parseInt(st.nextToken());

        if (a + b == c) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}