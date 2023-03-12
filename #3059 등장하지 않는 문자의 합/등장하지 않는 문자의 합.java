import java.io.*;
import java.util.Scanner;


public class Main { //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  //테스트 데이터 갯수 t 받는다.
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int n = str.length();
            int sum=0;
            boolean[] arr = new boolean[26];
            for (int j = 0; j < n; j++) {
                arr[str.charAt(j)-'A'] = true; //str.charAt(j)-'A' 붙이는 이유가 알파벳 배열중 A가 index가 0이니까 기준으로 몇번째 떨어져있는지 알기위해
            }
            for (int z = 0; z < 26; z++) {
                if (!arr[z]) { //있는애들은 true로 바꿨기때문에 부정을 해서 거짓이 되어서 sum에 더해지지 않는다.
                    sum += z + 'A'; //숫자 + '문자'는 아스키 코드로 변환됨.
                }
            }
            System.out.println(sum);
        }
    }
}
