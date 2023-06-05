import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sticks = new int[N];

        for (int i = 0; i < N; i++) {
            sticks[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        int maxPerimeter = maximum(sticks);
        System.out.println( maxPerimeter);
    }

    static int maximum(int[] sticks) {
        Arrays.sort(sticks); // 길이를 오름차순으로 정렬

        for (int i = sticks.length - 1; i >= 2; i--) {
            int a = sticks[i];
            int b = sticks[i - 1];
            int c = sticks[i - 2];

            if (a < b + c) {
                return a + b + c;
            }
        }

        return -1; // 삼각형을 만들 수 없는 경우
    }
}
