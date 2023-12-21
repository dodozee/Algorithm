import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{//박두지 화이팅
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int count = 1;

        for (int i = 0; i < N; i++) {
            if(str[i].equals("S")) count++;
            else{
                i++;
                count++;
            }
        }

        System.out.println(N> count? count: N);

    }
}