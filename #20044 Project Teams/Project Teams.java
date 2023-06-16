import java.util.Arrays;
import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 팀 수
        int[] abilities = new int[2 * n]; // 학생들의 코딩 역량 배열

        // 학생들의 코딩 역량 입력 받기
        for (int i = 0; i < 2 * n; i++) {
            abilities[i] = scanner.nextInt();
        }

        // 코딩 역량 배열 정렬
        Arrays.sort(abilities);

        // 팀별 코딩 역량 합 구하기
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = abilities[i] + abilities[2 * n - 1 - i];
            minSum = Math.min(minSum, sum);
        }

        System.out.println(minSum);
    }
}
