
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int pirodo = 0;
        int work = 0;

        for (int time = 0; time < 24; time++){
            if (pirodo + A <= M){
                pirodo += A;
                work += B;
            } else {
                pirodo -= C;
                if (pirodo < 0) pirodo = 0;
            }
        }
        System.out.println(work);
    }
}
