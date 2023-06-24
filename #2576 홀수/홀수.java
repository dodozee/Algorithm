import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[7]; // 입력받을 7개의 자연수를 저장할 배열

        // 7개의 자연수 입력 받기
        for (int i = 0; i < 7; i++) {
            numbers[i] = scanner.nextInt();
        }

        int sum = 0; // 홀수들의 합을 저장할 변수
        int minOdd = Integer.MAX_VALUE; // 홀수들 중 최솟값을 저장할 변수
        boolean hasOdd = false; // 홀수가 존재하는지 여부를 확인하는 변수

        // 주어진 자연수들을 확인하면서 홀수들의 합과 최솟값을 계산
        for (int i = 0; i < 7; i++) {
            int num = numbers[i];
            if (num % 2 == 1) { // 홀수인 경우
                hasOdd = true;
                sum += num;
                minOdd = Math.min(minOdd, num);
            }
        }

        // 홀수가 존재하는 경우 결과 출력
        if (hasOdd) {
            System.out.println(sum);
            System.out.println(minOdd);
        } else { // 홀수가 존재하지 않는 경우 -1 출력
            System.out.println(-1);
        }
    }
}
