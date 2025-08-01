import java.io.*;
import java.util.*;

/**
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();

        double D = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());

        double pow = Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2));
        double sqrt = Math.sqrt(pow);

        str.append((int)(sqrt*H) + " " + (int)(sqrt*W));

        System.out.print(str);
        br.close();
    }
}
