import java.io.*;

public class Main {//박두지 화이팅!
    public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            int current = Integer.parseInt(br.readLine());
            if (current == -1) break;
            sum+=current;
        }
        System.out.println(sum);
    }
    
}