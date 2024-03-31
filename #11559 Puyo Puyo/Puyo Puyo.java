import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[12][6];
    static int pop = 0;
    static boolean isPop = false;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();//한줄씩 입력받기

            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        while (true) {
            isPop = false;

            bfs();
            onFloor();

            if(!isPop) {
                break;
            } else {
                pop++; //터진 횟수 증가
            }
        }

        System.out.println(pop);

    }

    private static void onFloor() {
        for (int j = 0; j < 6; j++) {
            down(j);
        }
    }

    private static void down(int j) {
        Queue<Puyo> puyo = new LinkedList<>();
        int idx = 11;

        /*
        뿌요의 위치를 큐에 넣음, 가장 아래에 있는 빈 칸의 인덱스를 구함.
        큐에 있는 뿌요들을 가장 아래에 있는 빈 칸의 인덱스부터 넣어줌.

         */
        for (int i = 11; i >= 0; i--) {
            if(map[i][j] != '.'){
                puyo.add(new Puyo(i, j, map[i][j]));
                map[i][j] = '.';
            }
        }

        while(!puyo.isEmpty()){
            Puyo p = puyo.poll();

            char color = p.color;
            map[idx][j] = color;
            idx--;
        }

    }

    private static void bfs() {

        Queue<Puyo> queue = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.' && !visited[i][j]) {

                    ArrayList<int[]> list = new ArrayList<>();

                    queue.add(new Puyo(i,j, map[i][j]));
                    list.add(new int[]{i,j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Puyo p = queue.poll();

                        int curX = p.x;
                        int curY = p.y;
                        char curColor = p.color;

                        for (int t = 0; t < 4; t++) {
                            int nx = curX + dx[t];
                            int ny = curY + dy[t];

                            if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;

                            if (!visited[nx][ny] && map[nx][ny] == curColor) {
                                queue.add(new Puyo(nx, ny, curColor));
                                list.add(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    pop(list);
                }
            }
        }

    }

    private static void pop(ArrayList<int[]> list) {
        if (list.size() >= 4) {
            isPop = true;
            for (int[] arr : list) {
                map[arr[0]][arr[1]] = '.';
            }
        }
    }
}

class Puyo {
    int x;
    int y;
    char color;

    public Puyo(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
