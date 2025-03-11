import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        bw.write(String.valueOf(Collections.max(map.values())));
        bw.flush();
    }

}