import java.io.*;
import static java.lang.Math.min;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    public static void solution() throws IOException {
        int ans = Integer.MAX_VALUE;
        for(int bitCase = 0; bitCase<(1<<n);bitCase++){ 
            int sum = 0;
            for(int j=0;j<n;j++){ 
                int count = 0;
                for(int i=0;i<n;i++){
                    char tmp = map[i][j];
                    if(( bitCase & (1<<i) ) != 0) {
                        tmp = reverse(tmp); 
                    }
                    if(tmp == 'T')  count += 1; 
                }
                sum += min(count,n-count); 
            }
            ans = min(ans,sum); 
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static char reverse(char value){
        if( value=='T') return 'H';
        else return 'T';
    }
}