import java.io.*;
public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().split(" ");
            for (String word : words) {
                StringBuilder sb = new StringBuilder(word);
                System.out.print(sb.reverse().toString() + " ");
            }
            System.out.println();
        }
    }
}