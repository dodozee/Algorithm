import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> keywords = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String[] words = br.readLine().split(",");
            for (String word : words) {
                keywords.remove(word); 
            }
            bw.write(keywords.size() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}