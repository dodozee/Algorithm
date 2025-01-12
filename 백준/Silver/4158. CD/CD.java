import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int m;
    static HashSet<Integer> set;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            set = new HashSet<>();
            answer = 0;
            if (n == 0 && m == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            for(int i = 0; i < m; i++){
                if(set.contains(Integer.parseInt(br.readLine()))){
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}