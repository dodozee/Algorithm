import java.util.Scanner;

public class Main {//박두지 화이팅!!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 데이터의 수

        for (int t = 0; t < T; t++) {
            int sumOfEvens = 0; // 짝수의 합
            int minEven = 101; // 초기 최솟값을 101로 설정 (주어진 범위를 벗어나는 값)

            for (int i = 0; i < 7; i++) {
                int num = scanner.nextInt();

                if (num % 2 == 0) { // 짝수인 경우
                    sumOfEvens += num; // 짝수의 합을 더함
                    minEven = Math.min(minEven, num); // 최솟값 업데이트
                }
            }

            System.out.println(sumOfEvens + " " + minEven);
        }

        scanner.close();
    }
}
