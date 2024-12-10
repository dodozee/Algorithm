import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;

        
        int[][] ingredients = new int[n][2];
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        int lth = 1<<n;
        for(int i=1; i<lth; ++i){
            int sour=1, bitter = 0;
            for(int j=0; j<n; ++j){ 
                if((i & 1<<j) > 0){ 
                    sour *= ingredients[j][0];
                    bitter += ingredients[j][1];
                }
            }
            int diff = Math.abs(sour - bitter);
            ans = Math.min(ans, diff);
        }

        System.out.print(ans);
    }
}