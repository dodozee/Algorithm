import java.util.Scanner;

public class Main {//박두지 화이팅!!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 아파트 거주민 수 계산
        int[][] apt = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apt[i][1] = 1;  // i층 1호
            apt[0][i] = i;  // 0층 i호
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }

        // 거주민 수 출력
        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(apt[k][n]);
        }
    }
}
