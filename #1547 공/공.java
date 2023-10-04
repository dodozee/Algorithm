import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cups = {1, 0, 0}; // 1번 컵에 공이 있는 상태로 초기화

        int M = scanner.nextInt(); // 컵 위치를 바꾸는 횟수

        for (int i = 0; i < M; i++) {
            int X = scanner.nextInt(); // X번 컵과
            int Y = scanner.nextInt(); // Y번 컵 위치 바꾸기

            // X와 Y 위치의 컵을 바꾸기
            int temp = cups[X - 1];
            cups[X - 1] = cups[Y - 1];
            cups[Y - 1] = temp;
        }

        // 공이 있는 컵 번호 찾기
        int ballPosition = -1;
        for (int i = 0; i < 3; i++) {
            if (cups[i] == 1) {
                ballPosition = i + 1;
                break;
            }
        }

        System.out.println(ballPosition);

        scanner.close();
    }
}
