import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int T = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        for (int i = 0; i < T; i++) {
            // A와 B 입력 받기
            String input = scanner.nextLine();
            String[] numbers = input.split(",");

            int A = Integer.parseInt(numbers[0]);
            int B = Integer.parseInt(numbers[1]);

            // A와 B의 합 계산
            int sum = A + B;

            // 합 출력
            System.out.println(sum);
        }
    }
}
