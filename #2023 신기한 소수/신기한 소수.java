import java.io.*;
import java.util.*;
/* 박두지 파이팅!!! 갓천대 컴공 파이팅!!
[풀이 과정]
1.신기한 소수란, 왼쪽으로부터 1자리, 2자리, 3자리, 4자리, 5자리 등 숫자가 모두가 소수인 수를 말한다.
2.입력으로는 N하나만 주어지고, 출력으로는 N자리의 신기한 소수 모두를 오름차순으로 정렬해서 출력한다.

 */

import java.util.ArrayList;

public class Main {

    static StringBuilder sb = new StringBuilder();
    // 소수 판별 메소드
    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    // 신기한 소수 찾기 메소드
    public static void findInterestingPrime(int num, int len) {
        if (len == 0) {
           if(isPrime(num)) sb.append(num).append("\n");
            return;
        }
        for (int i = 0; i <= 9; i ++) {
            int nextNum = num * 10 + i;
            if (isPrime(nextNum)) findInterestingPrime(nextNum, len-1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        findInterestingPrime(0, n);

        // 결과 출력
        System.out.println(sb);
    }
}
