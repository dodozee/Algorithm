import java.util.*;

public class Main {
    public static void main(String[] args) {
        String answer = "NO";
        
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        
        int n = kb.nextInt();
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = kb.next();
            int b = kb.nextInt();
            map.put(a, map.getOrDefault(a,0)+b);
        }
        
        
        for (String key : map.keySet()) {
            if(map.get(key)==5) answer ="YES";
        }
        System.out.println(answer);
    }
}