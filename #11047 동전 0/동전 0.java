
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {//갓천대! 최고!! 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // static 매서드를 사용하기 위해서 static으로 정의.
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0; //최소 동전 갯수 카운트!
        int n = Integer.parseInt(st.nextToken());;//종류 n개을 받고 숫자로 변환한다
        int k = Integer.parseInt(st.nextToken());//총 합계

        Integer[] coin = new Integer[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin, Collections.reverseOrder());//동전 종류 받아서 역순으로 나열(큰->작은)

        for (int i = 0; i < n; i++) {
            count += k/coin[i]; //단위가 큰수자의 몫부터 더한다. 
            k %= coin[i];//단위 큰걸 뺀 나머지!
        }
        System.out.println(count);
    }
}