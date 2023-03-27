import java.io.*;
import java.util.*;

public class Main {//박두지 짱! 갓천대 컴공 화이팅! 개발자 가즈아

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxInc = 1; // 연속해서 커지는 수열의 길이
        int maxDec = 1; // 연속해서 작아지는 수열의 길이
        int curInc = 1; // 현재 연속해서 커지는 수열의 길이
        int curDec = 1; // 현재 연속해서 작아지는 수열의 길이

        for (int i = 1; i < n; i++) {
            // 현재 숫자가 이전 숫자보다 크거나 같으면, curInc 증가
            if (arr[i] >= arr[i-1]) curInc++;
            else curInc = 1;

            // 현재 숫자가 이전 숫자보다 작거나 같으면, curDec 증가
            if (arr[i] <= arr[i-1]) curDec++;
            else curDec = 1;

            // maxInc, maxDec 값 갱신
            maxInc = Math.max(maxInc, curInc);
            maxDec = Math.max(maxDec, curDec);
        }

        // maxInc, maxDec 중 더 큰 값을 출력
        System.out.println(Math.max(maxInc, maxDec));
    }
}


