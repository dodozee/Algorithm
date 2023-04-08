import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean found = false;  // 수열 찾기 여부를 체크하는 변수
        for (int len = L; len <= 100; len++) {  // 수열 길이를 L부터 100까지 늘려가며 검사
            int start = N / len - (len - 1) / 2;  // 수열의 시작점 계산
            if (start < 0) {
                continue;  // 시작점이 음수이면 검사할 필요 없음
            }
            int sum = (start + start + len - 1) * len / 2;  // 수열의 합 계산
            if (sum == N) {  // 수열의 합이 N과 같으면 출력하고 종료
                for (int i = 0; i < len; i++) {
                    System.out.print(start + i + " ");
                }
                found = true;
                break;
            }
        }

        if (!found) {  // 수열을 찾지 못한 경우 -1 출력
            System.out.println("-1");
        }
    }
}

