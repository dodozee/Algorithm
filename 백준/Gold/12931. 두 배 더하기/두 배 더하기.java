import java.io.*;
import java.util.*;

public class Main {
    static int answer, maxMultiply;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            findAnswer(Integer.parseInt(st.nextToken()));
        }
        answer += maxMultiply;

        System.out.println(answer);

    }

    static void findAnswer(int num) {
        String binaryString = Integer.toBinaryString(num);
        int bitCount = Integer.bitCount(num);
        maxMultiply = Math.max(maxMultiply, binaryString.length() - 1);
        answer += bitCount;
    }
}
