import java.io.*;
import java.util.*;

public class Main{//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<A; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int j=0; j<B; j++) {
            int num = Integer.parseInt(st.nextToken());
            treeSet.remove(num);
        }


        sb.append(treeSet.size()+"\n");
        for (Integer num : treeSet) {
            sb.append(num+ " ");
        }
        System.out.println(sb);
    }
}