import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅~
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<String> words =new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String w = br.readLine();
            String[] word = w.split(" ");
            for (int j = 0; j < word.length; j++) {
                words.push(word[j]);
            }
            sb.append("Case #" + (i+1) + ": ");
            for (int j = 0; j < word.length; j++) {
                sb.append(words.pop()).append(" ");
            }
            sb.append('\n');
            
        }
        System.out.println(sb);
    }
}