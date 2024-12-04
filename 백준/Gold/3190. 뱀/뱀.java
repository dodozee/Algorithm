import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];// 0행, 0열은 사용하지 않음

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 1; // 사과가 있는 칸은 1로 표시
        }

        int L = Integer.parseInt(br.readLine());

        Queue<Spin> spinQueue = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            spinQueue.offer(new Spin(time, dir)); // 방향 전환 정보 저장

        }


        int row = 1;
        int col = 1;
        int time = 0;
        int dir = 1;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        map[row][col] = 2;

        while(true){
            int dR = row + dr[dir]; // 다음 행
            int dC = col + dc[dir]; // 다음 열

            time++;

            if (dR < 1 || dC < 1 || dR > N || dC > N) { // 벽에 부딪히면
                break;
            } else if (map[dR][dC] == 2) { // 뱀의 몸통과 부딪히면
                break;
            } else if (map[dR][dC] == 0) { // 사과가 없으면
                Node tail = q.poll();
                map[tail.row][tail.col] = 0;// 꼬리칸 제거 -> 꼬리칸이 비어있는 칸이므로 0으로 초기화
            }

            if (!spinQueue.isEmpty()) {
                if (time == spinQueue.peek().time) { // 방향 전환 시간이면
                    Spin spin = spinQueue.poll();

                    if (spin.dir.equals("L")) {
                        dir = (dir + 3) % 4;
                    }
                    if (spin.dir.equals("D")) {
                        dir = (dir + 1) % 4;
                    }
                }
            }
            map[dR][dC] = 2;
            q.offer(new Node(dR, dC));
            row = dR;
            col = dC;
        }

        System.out.println(time);
    }

}

class Spin{
    int time;
    String dir;
    Spin(int time, String dir) {
        this.time = time;
        this.dir = dir;
    }


}

class Node{
    int row, col;
    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}