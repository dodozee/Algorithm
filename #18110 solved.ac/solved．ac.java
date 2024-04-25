import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int t = Integer.parseInt(br.readLine());
        int cut = (int) Math.round(t * 0.15);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list); // 오름차순 정렬

        int size = t - (cut * 2);// 15% 제외한 값

        for (int i = cut; i < size + cut; i++) {
            result += list.get(i);
        }

        System.out.println((int) Math.round((double) result / size));


    }


}