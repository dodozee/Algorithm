import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 퀸이 이동할 수 있는 위치는 상하좌우, 대각선 방향으로 이동할 수 있다.
 * 재퀴 탐색을 통해 열의 행의 값을 찾고 그 값이 가능한지 확인한다.
 * 즉, 재퀴탐색을 하게된다면 기본적으로 '열'은 서로 다른 위치이니 우리가 검사할 부분은 다른 퀸과 동일한 '행'에 위치하는지
 * 대각선상에 위치하는지를 검사하면된다.
 */
public class Main {
    static int[] arr; //퀸의 위치를 저장하는 배열 (인덱스는 열, 값은 행)
    static int N; //퀸의 개수
    static int count = 0; //경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);

    }
    public static void nQueen(int depth){
        //행을 다 채운다면 카운트를 1 증가시키고 리턴시킨다.

        if(depth == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            //해당 열에서 퀸을 놓을 수 있는 경우
            if(possibility(depth)){
                nQueen(depth + 1);
            }
        }
    }

    public static boolean possibility(int column) {
        //해당 열의행과 i열의 행이 일치하는 경우 (같은 행에 존재하는 경우)
        for (int i = 0; i < column; i++) {
            if (arr[column] == arr[i]) {
                return false;

                //대각선상에 놓여있는 경우
                //열의 차와 행의 차가 같은 경우가 대각선에 놓여있는 경우이다.
            } else if (Math.abs(column - i) == Math.abs(arr[column] - arr[i])) {
                return false;
            }
        }
        return true;

    }
}
