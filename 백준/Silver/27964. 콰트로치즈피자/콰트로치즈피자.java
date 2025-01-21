import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String tp = st.nextToken();
            if (tp.endsWith("Cheese")) set.add(tp);
        }

        if (3 < set.size()) System.out.print("yummy");
        else System.out.print("sad");

    }

}