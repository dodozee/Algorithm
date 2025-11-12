import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        int maxLength = -1; 
        String a = "";
        String b = "";

        for (int i = 0; i < n - 1; i++) {
            String now = strings[i];
            if(now.length() <= maxLength) continue; 
            for (int j = i+1; j < n; j++) {
                String next = strings[j];
                if(next.length() <= maxLength) continue; 
                int length = commonLength(strings[i], strings[j]);

                if(length > maxLength){
                    maxLength = length;
                    a = strings[i];
                    b = strings[j];
                }
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
    
    static int commonLength(String a, String b) {
        int length = Math.min(a.length(), b.length());
        int idx = 0;
        while (idx < length && a.charAt(idx) == b.charAt(idx)) {
            idx++;
        }
        return idx;
    }
}