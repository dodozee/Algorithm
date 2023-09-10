import java.util.Scanner;

public class Main {//박두지 화이팅!!!
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[][] bingo = new int[5][5];
            boolean[][] checked = new boolean[5][5];

            // 빙고판 입력 받기
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    bingo[i][j] = sc.nextInt();
                }
            }

            // 부른 수 입력 받기
            int[] call = new int[25];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    call[i * 5 + j] = sc.nextInt();
                }
            }

            int count = 0;

            // 사회자가 부르는 수 체크
            for (int num : call) {
                count++;
                boolean found = false;

                // 빙고판에서 해당 숫자 찾기
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (bingo[i][j] == num) {
                            checked[i][j] = true;
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }

                // 빙고 체크
                int bingoCount = 0;

                // 가로 체크
                for (int i = 0; i < 5; i++) {
                    boolean bingoRow = true;
                    boolean bingoCol = true;
                    for (int j = 0; j < 5; j++) {
                        if (!checked[i][j]) {
                            bingoRow = false;
                        }
                        if (!checked[j][i]) {
                            bingoCol = false;
                        }
                    }
                    if (bingoRow) bingoCount++;
                    if (bingoCol) bingoCount++;
                }

                // 대각선 체크
                boolean bingoDiagonal1 = true;
                boolean bingoDiagonal2 = true;
                for (int i = 0; i < 5; i++) {
                    if (!checked[i][i]) {
                        bingoDiagonal1 = false;
                    }
                    if (!checked[i][4 - i]) {
                        bingoDiagonal2 = false;
                    }
                }
                if (bingoDiagonal1) bingoCount++;
                if (bingoDiagonal2) bingoCount++;

                if (bingoCount >= 3) {
                    break;
                }
            }

            System.out.println(count);
        }


}
