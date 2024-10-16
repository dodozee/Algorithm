
import java.io.*;
import java.util.*;

public class Main {
    private static final int DAY_OF_YEAR = 365;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[DAY_OF_YEAR + 1];

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int i = s; i <= e; i++) {
                count[i]++;
            }
        }
        
        int sum = 0;
        int maxHeight = 0;
        int width = 0;
        for (int i = 0; i <= DAY_OF_YEAR; i++) {
            if (count[i] == 0) {
                sum += maxHeight * width;
                maxHeight = 0;
                width = 0;
                continue;
            }
            width++;
            maxHeight = Math.max(maxHeight, count[i]);
        }
        
        sum += maxHeight * width;
        System.out.println(sum);
    }
}


