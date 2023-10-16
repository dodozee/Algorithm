import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        int[][] rectangle = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                rectangle[i][j] = line.charAt(j) - '0';
            }
        }

        int maxSide = 1; // 최소 크기는 1
        boolean found = false;

        // 정사각형의 한 변의 길이를 1부터 시작하여 점차 키워가며 확인
        for (int side = 2; side <= Math.min(N, M); side++) {
            for (int i = 0; i <= N - side; i++) {
                for (int j = 0; j <= M - side; j++) {
                    if (rectangle[i][j] == rectangle[i][j + side - 1] &&
                        rectangle[i][j] == rectangle[i + side - 1][j] &&
                        rectangle[i][j] == rectangle[i + side - 1][j + side - 1]) {
                        maxSide = side; // 정사각형을 찾았으므로 최대 크기 업데이트
                        found = true;
                    }
                }
            }
        }

        System.out.println(maxSide * maxSide); // 정답 출력
    }
}
