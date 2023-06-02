import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine();
        int length = str.length();

        String[] suffixes = new String[length];

        for (int i = 0; i < length; i++) {
            suffixes[i] = str.substring(i);
        }

        Arrays.sort(suffixes);

        for (String suffix : suffixes) {
            System.out.println(suffix);
        }
    }
}