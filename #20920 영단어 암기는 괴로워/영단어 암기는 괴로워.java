import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M){
                continue;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        List<String> words = new ArrayList<>(map.keySet());
        
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (Integer.compare(map.get(s1), map.get(s2)) != 0) {
                    return Integer.compare(map.get(s2), map.get(s1));
                }
                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }
                return s1.compareTo(s2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}