import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String L = st.nextToken();
        String R = st.nextToken();

        int answer = 0;

        if(L.length() != R.length()){
            System.out.println(answer);
        }
        else {
            int i = 0;
            while( i < L.length() && L.charAt(i) == R.charAt(i)) {
               if(L.charAt(i)  == '8') {
                   answer++;
               }
               i++;
            }
            System.out.println(answer);
        }
    }
}