import java.io.*;
import java.util.*;

public class Main { //문제 이해하는데 어려웠다. //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //세로크기
        int m = Integer.parseInt(st.nextToken()); //가로크기
        int x = Integer.parseInt(st.nextToken()); //처음에 둘 북쪽에서 떨어진 거리
        int y = Integer.parseInt(st.nextToken()); //처음에 둘 서쪽에서 떨어진 거리
        int k = Integer.parseInt(st.nextToken()); //명령할 갯수

        int[][] map = new int[n][m]; //맵이 n X m 크기의 2차 배열로 만든다고생각하면됨!

        for (int i = 0; i < n; i++) { //map 밑에 숫자 새기는 중!
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dice = new int[7]; //윗면이 1의 기준이므로 Index는 1개씩 다 더할것임. 그래서 배열의 크기 7로 선언

        int[] x_direction = {0, 0, -1, 1}; //입력 마지막줄에 명령을 입력하는데, 그 명령(동서남북)에 따라  (x,y)좌표의 이동 위치를 알려준다.
        int[] y_direction = {1, -1, 0, 0};
        int nx, ny; //주사위의 위치 좌표

        st = new StringTokenizer(br.readLine()); //명령 한줄을 받아서 나뉠 예정
        while (k > 0) {
            int direction =Integer.parseInt(st.nextToken()); //토큰으로 나뉘어진 명령어를 하나씩 direction에 넣고 while문 돌림
            nx = x + x_direction[direction - 1]; //최초에 있던 좌표에서 명령하는곳으로 이동하는 것.
            ny = y + y_direction[direction - 1]; //상동

            if(nx>=0 && nx < n && ny >= 0 && ny < m){ //만약 '주사위의 위치좌표가 맵의 크기에 벗어지 않았다면'의 조건식
                int top = dice[1]; //1은 윗면이라 top에 저장

                try {
                    if (direction == 1) { //1일때는 동쪽
                        dice[1] = dice[4]; //왼쪽에 있는것을 위로 가고
                        dice[4] = dice[6]; //바닥에 있는것을 왼쪽으로 가고
                        dice[6] = dice[3]; // 오른쪽에 있는것이 바닥에 간다.
                        dice[3] = top; // 윗면에 있던 것은 오른쪽면에  간다.
                    } else if (direction == 2) {
                        dice[1] = dice[3];
                        dice[3] = dice[6];
                        dice[6] = dice[4];
                        dice[4] = top;
                    } else if (direction == 3) {
                        dice[1] = dice[5];
                        dice[5] = dice[6];
                        dice[6] = dice[2];
                        dice[2] = top;
                    } else if (direction == 4) {
                        dice[1] = dice[2];
                        dice[2] = dice[6];
                        dice[6] = dice[5];
                        dice[5] = top;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("1~4(동서남북) 그 이외 숫자는 없습니다.");
                }
                x=nx;
                y=ny;
                if (map[x][y] == 0) { //바닥이 0일경우에는 주사위에 있는 숫자를 바닥에 복사.
                    map[x][y] = dice[6];
                }else{
                    dice[6] = map[x][y]; //바닥에 있는 숫자가 주사위 바닥에 복사
                    map[x][y] =0;//그리고 바닥에 있는 숫자는 0으로 바꿈
                }
                System.out.println(dice[1]);// 맨 위칸을 출력
            }
            k--;


        }
    }
}
