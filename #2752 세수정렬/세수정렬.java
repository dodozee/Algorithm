import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lists = new int[3];
        for (int i = 0; i < 3; i++) {
           lists[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lists);

        for (int list : lists) {
            System.out.print(list + " ");
        }
    }
}