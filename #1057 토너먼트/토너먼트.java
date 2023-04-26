import java.util.*;
import java.io.*;
public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int round = 0; // 김지민과 임한수가 대결하는 라운드 번호
        while (a != b) { // 김지민과 임한수가 대결할 때까지 반복
            a = (a + 1) / 2; // 다음 라운드에서의 번호를 계산
            b = (b + 1) / 2;
            round++; // 라운드 번호 증가
        }

        System.out.println(round);
    }
}
