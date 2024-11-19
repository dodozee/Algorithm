import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/*
분석

 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long result = n - m;
        System.out.println(result > 0 ? result : -1*result);
    }
}

