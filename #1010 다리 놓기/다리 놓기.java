import java.util.*;
import java.io.*;
/* 박두지 화이팅!! 갓천대 컴공 화이팅!!
[문제풀이]
1. 동적 프로그래밍을 이용하여 해결하였다.
2. 강 서쪽의 사이트와 동쪽의 사이트를 이어주는 다리를 선택하는 것은 서쪽에서 하나씩 선택해가면서 가능한 동쪽의 사이트중 연결 할것을 선택
3. 이항계수와 같이 파스칼의 삼각형을 이용하여 해결할 수 있다.
*/
public class Main  {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스의 개수 입력 받기

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()); // 공백 기준으로 문자열 분리하기
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[][] dp = new long[N + 1][M + 1]; // 다이나믹 프로그래밍을 위한 배열 선언하기

            for (int j = 1; j <= M; j++) {
                dp[1][j] = j; // 첫 번째 사이트를 선택한 경우의 수는 동쪽 사이트의 개수와 같음
            }

            for (int j = 2; j <= N; j++) {
                for (int k = j; k <= M; k++) {
                    for (int l = k - 1; l >= j - 1; l--) { // 이전 선택한 다리들과 겹치지 않도록 반복문 조건 설정
                        dp[j][k] += dp[j - 1][l]; // 이전 선택한 다리들과 현재 다리를 연결한 경우의 수 누적
                    }
                }
            }

            System.out.println(dp[N][M]); // 가능한 경우의 수 출력
        }
        
    }
}
