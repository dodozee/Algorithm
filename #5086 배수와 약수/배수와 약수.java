import java.io.*;
import java.util.StringTokenizer;

public class Main {//갓천댓~~ 두지코딩~~
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result ; //StringBuilder는 객체를 생성하고 append()메서드를 사용하면 chain 방식으로 문자열을 추가한다.

        String f = "factor\n";
        String m = "multiple\n";
        String n = "neither\n";

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            result = new StringBuilder();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x ==0 && y ==0)
                break;
            if (y % x == 0) { // x는 y로 나눴을때 나머지가 0이란 뜻이라 x가 y의 약수이다.
                result.append(f);
            } else if (x % y == 0) { //y를 x로 나눴을때 나머지가 0이란 뜻은 x는 y의 배수이다.
                result.append(m);
            } else {
                result.append(n);
            }
            System.out.print(result);

        }
    }

}