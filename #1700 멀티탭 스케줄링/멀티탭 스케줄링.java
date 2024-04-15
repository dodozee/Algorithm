import java.io.*;
import java.util.*;


/**
 * 그리디
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            int num = list.get(i);

            if(set.contains(num) || (set.size()<n && set.add(num))) {
                continue;
            }

            int max = -1;
            int idx = -1;

            for (int s : set) {
                int temp = 0;

                List<Integer> sub = list.subList(i + 1, k);

                if(sub.contains(s)){
                    temp = sub.indexOf(s);
                }else{
                    temp = k - i - 1;
                }

                if(temp > max){
                    max = temp;
                    idx = s;
                }

            }
            set.remove(idx);
            set.add(num);
            cnt++;

        }
            System.out.println(cnt);
    }
}