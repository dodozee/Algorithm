import java.io.*;
import java.util.*;
/* 박두지 화이팅! 갓천대 컴공 화이팅!
[문제 해석 및 풀이]
1.먼저, 테스트 케이스에 수 t를 받고 while문을 이용하여 t번 반복한다.
2.그리고 각 테스트 케이스마다 정수 n을 받고 i를 2부터 시작하여 소인수 분해한다.
3.while문 안에서는, i가 n의 약수인 동안 i를 계속 나누어가며 n을 갱신해준다.이 때 i의 개수를 카운트한다.
4.카운트한 개수가 0보다 큰 경우에만 sb에 i와 count를 추가하고, 개행 문자도 추가한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int i = 2;
            while (n > 1) {
                int count = 0;
                while (n % i == 0) {
                    count++;
                    n /= i;
                }
                if (count > 0) {
                    sb.append(i).append(" ").append(count).append("\n");
                }
                i++;
            }
        }
        System.out.println(sb.toString());
    }
}
