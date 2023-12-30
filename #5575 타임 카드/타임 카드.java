import java.io.*;
import java.util.*;

public class Main{//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i =0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            int t1 = h1*60*60 + m1*60 + s1;
            int t2 = h2*60*60 + m2*60 + s2;

            int t = t2 - t1;

            int hour = (t/60)/60 % 24;
            int min = (t/60) % 60;
            int second = t % 60;

            System.out.println(hour + " " + min + " " + second);

        }



    }
}
