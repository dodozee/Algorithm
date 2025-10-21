import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a * a == (b * b) + (c * c) || b * b == (a * a) + (c * c) || c * c == (a * a) + (b * b)) System.out.println(1);
        else if (a == b && b == c) System.out.println(2);
        else System.out.println(0);
    }
}