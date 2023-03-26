import java.io.*;
import java.util.*;
/* 박두지 화이팅! 갓천대 컴공 화이팅!
[문제 해석 및 풀이]
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        int count =0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (list.get(i) + list.get(j)==M) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}