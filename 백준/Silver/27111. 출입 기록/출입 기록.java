
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, number = 0;
    static int[] check = new int[200001]; // 1 ~ 200000까지 체크하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 총 입장 기록 수
        int ans = 0;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 입장자 ID
            int y = Integer.parseInt(st.nextToken()); // 입장 여부

            number = Math.max(number, x);
            if (y == 0) {
                // 퇴장
                if (check[x] == 1) {
                    check[x] = 0; // 이미 들어온 사람이면 체크를 0으로
                } else {
                    ans++; // 입장 기록이 없던 사람이라면 누락
                }
            } else {
                // 입장
                if (check[x] == 1) {
                    ans++; // 이미 들어온 사람이면 누락
                } else {
                    check[x] = 1; // 새롭게 들어왔다고 체크
                }
            }
        }

        // 마지막으로 1부터 number까지 체크
        for (int i = 1; i <= number; i++) {
            if (check[i] != 0) ans++; // 남아있는 체크값이 있으면 누락 추가
        }

        System.out.println(ans);
    }
}
