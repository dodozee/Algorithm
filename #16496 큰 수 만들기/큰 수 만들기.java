import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String[] arr = new String[t];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < t; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, ((x, y) -> (y + x).compareTo(x + y)));//이 정렬은 두 문자열을 합쳤을 때 더 큰 수가 되는 순서로 정렬한다.

        for (String s : arr) {
            sb.append(s);
        }

        if(sb.charAt(0) == '0')
            System.out.println(0);
        else
            System.out.println(sb);

    }

}