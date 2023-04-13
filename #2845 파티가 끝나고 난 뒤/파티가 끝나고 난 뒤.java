import java.util.*;
import java.io.*;

public class Main{//박두지 화이팅!!! 갓천대 컴공 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int sum = n* m;

        st = new StringTokenizer(br.readLine());
        int[] news = new int[5];

        for (int i = 0; i < 5; i++) {
            news[i] = Integer.parseInt(st.nextToken());
            sb.append(news[i]-sum).append(" ");
        }


        System.out.println(sb);

    }
}