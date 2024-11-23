import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 척이의 기물 수 입력
        int[] chegiPieces = new int[6]; // 차, 포, 마, 상, 사, 졸
        for (int i = 0; i < 6; i++) {
            chegiPieces[i] = scanner.nextInt();
        }

        // 은규의 기물 수 입력
        int[] eungyuPieces = new int[6]; // 차, 포, 마, 상, 사, 졸
        for (int i = 0; i < 6; i++) {
            eungyuPieces[i] = scanner.nextInt();
        }

        // 각 기물의 점수
        int[] scores = {13, 7, 5, 3, 3, 2}; // 차, 포, 마, 상, 사, 졸

        // 척이의 점수 계산
        int chegiScore = 0;
        chegiScore += chegiPieces[0] * scores[0]; // 차
        chegiScore += chegiPieces[1] * scores[1]; // 포
        chegiScore += chegiPieces[2] * scores[2]; // 마
        chegiScore += chegiPieces[3] * scores[3]; // 상
        chegiScore += chegiPieces[4] * scores[4]; // 사
        chegiScore += chegiPieces[5] * scores[5]; // 졸

        // 은규의 점수 계산
        int eungyuScore = 0;
        eungyuScore += eungyuPieces[0] * scores[0]; // 차
        eungyuScore += eungyuPieces[1] * scores[1]; // 포
        eungyuScore += eungyuPieces[2] * scores[2]; // 마
        eungyuScore += eungyuPieces[3] * scores[3]; // 상
        eungyuScore += eungyuPieces[4] * scores[4]; // 사
        eungyuScore += eungyuPieces[5] * scores[5]; // 졸

        // 한나라의 점수에 1.5점을 추가
        eungyuScore += 1.5;

        // 점수 비교 및 결과 출력
        if (chegiScore > eungyuScore) {
            System.out.println("cocjr0208");
        } else {
            System.out.println("ekwoo");
        }

        scanner.close();
    }
}
