import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] rectangles = new int[101][101]; // 직사각형의 좌표를 저장할 배열

        // 네 개의 직사각형 입력 받아서 배열에 표시
        for (int i = 0; i < 4; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            // 직사각형 내부를 1로 표시
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    rectangles[x][y] = 1;
                }
            }
        }

        int area = 0;

        // 배열을 순회하면서 1로 표시된 부분의 개수를 세어 면적을 구함
        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                area += rectangles[x][y];
            }
        }

        System.out.println(area);

        scanner.close();
    }
}
