import java.io.*;
import java.util.*;
 
public class Main {	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		
        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][6];
		
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
        int sum = 0;
        int ans = 0;
        for (int i=0; i<6; i++) {
            int bot = dice[0][i];       
            int top = dice[0][setTop(i)]; 
			
            for (int d=0; d<N; d++) {
                int max = 0;
				
                for (int k=0; k<6; k++) {
                    if (dice[d][k] == top) {
                        bot = top;
                        top = dice[d][setTop(k)];
						
                        max = findMax(bot, top);
                        break;
                    }
                }
                sum += max;
            }
            ans = Math.max(ans, sum);
            sum = 0;
        }
        System.out.println(ans);
    }
	
    public static int setTop (int idx) {
        if (idx == 0) return 5;
        else if (idx == 1) return 3;
        else if (idx == 2) return 4;
        else if (idx == 3) return 1;
        else if (idx == 4) return 2;
        else return 0;
    }
	
    public static int findMax (int bot, int top) {
        for (int i=6; i>0; i--) {
            if (i != bot && i != top) {
                return i;
            }
        }
        return 0;
    }
}
