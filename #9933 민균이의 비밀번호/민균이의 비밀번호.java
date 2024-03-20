 

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 

        Set<String> sets = new HashSet<>(); 

        for (int i = 0; i < N; i++) {
            String s = br.readLine(); 

            sets.add(s); 

            StringBuilder sb = new StringBuilder(s);
            String reverse = sb.reverse().toString();

            if (sets.contains(reverse)) { 
                System.out.println(reverse.length() + " " + reverse.charAt(reverse.length() / 2));
                break; 
            }
        }
    }
}