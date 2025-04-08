import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] goalArr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String now = br.readLine();
        String goal = br.readLine();

        boolean[] b1 = new boolean[N];  // 첫 번째 전구 스위치 켠 상태
        boolean[] b2 = new boolean[N];  // 첫 번째 전구 스위치 끈 상태
        goalArr = new boolean[N];

        for (int i = 0; i < N; i++) {
            b1[i] = now.charAt(i) != '0';
            b2[i] = now.charAt(i) != '0';
            goalArr[i] = goal.charAt(i) != '0';
        }

        // 첫 번째 전구 스위치 사용하지 않고 진행
        greedy(1, 0, b1);
        // 첫 번째 전구 스위치 사용하고 진행
        greedy(1, 1, useSwitch(0, b2));

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void greedy(int idx, int cnt, boolean[] b) {
        if (idx == N) {
            if (b[idx - 1] == goalArr[idx - 1]) {
                min = Math.min(min, cnt);
            }
            return;
        }

        if (b[idx - 1] != goalArr[idx - 1])  // 같지 않으면 스위치 사용하기
            greedy(idx + 1, cnt + 1, useSwitch(idx, b));
        else    // 같으면 스위치 사용하지 않고 다음 인덱스로 넘어가기
            greedy(idx + 1, cnt, b);
    }

    // 스위치 켜는 함수
    private static boolean[] useSwitch(int idx, boolean[] b) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (0 <= i && i < N)
                b[i] = !b[i];
        }
        return b;
    }
}
