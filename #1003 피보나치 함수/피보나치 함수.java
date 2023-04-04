import java.util.*;

public class Main { //갓천대 화이팅!!! 박두지 화이팅!!
    static int[][] dp = new int[41][2]; // 메모이제이션 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 수
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // n 값
            int[] count = fibonacci(n); // fibonacci 메소드 호출
            System.out.println(count[0] + " " + count[1]); // 결과 출력
        }
        sc.close();
    }

    public static int[] fibonacci(int n) {
        if (dp[n][0] != 0 || dp[n][1] != 0) { // 이미 계산된 값이 있다면
            return dp[n]; // 메모이제이션된 값 반환
        } else {
            int[] count1 = fibonacci(n - 1); // n-1번째 피보나치 수열 결과
            int[] count2 = fibonacci(n - 2); // n-2번째 피보나치 수열 결과
            int[] count = new int[2]; // 0과 1이 출력된 횟수를 저장할 배열
            count[0] = count1[0] + count2[0]; // 0이 출력된 횟수 = n-1번째와 n-2번째 결과의 0이 출력된 횟수의 합
            count[1] = count1[1] + count2[1]; // 1이 출력된 횟수 = n-1번째와 n-2번째 결과의 1이 출력된 횟수의 합
            dp[n] = count; // 계산 결과를 메모이제이션 배열에 저장
            return count; // 결과 반환
        }
    }
}



