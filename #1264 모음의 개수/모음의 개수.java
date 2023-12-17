import java.io.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("#")) {
                break;
            }

            str = str.toLowerCase();
            int answer = 0;

            for (int i = 0; i < str.length(); i++) {
                char t = str.charAt(i);
                if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
