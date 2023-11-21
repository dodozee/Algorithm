
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {//박두지 화이팅~~ bfs로 품
    public static int N;
    public static int M;
    public static int[][] box;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }
        bfs();

    }
    public static void bfs(){
        int day = 0;
        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();
            day = tomato.day;

            for(int i=0; i<4; i++){
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(box[nx][ny] == 0){
                        box[nx][ny] = 1;
                        queue.offer(new Tomato(nx, ny, day+1));
                    }
                }
            }
        }
        if(checkTomato()){
            System.out.println(day);

        }else{
            System.out.println(-1);
        }

    }
    static boolean checkTomato(){
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}

class Tomato{
    int x;
    int y;
    int day;

    public Tomato(int x, int y, int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }

}
