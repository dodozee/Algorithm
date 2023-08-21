import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dateLastDigit = scanner.nextInt(); // 날짜의 일의 자리 숫자
        int[] carNumbers = new int[5]; // 5대의 자동차 번호의 일의 자리 숫자를 저장할 배열

        for (int i = 0; i < 5; i++) {
            carNumbers[i] = scanner.nextInt(); // 5대의 자동차 번호의 일의 자리 숫자 입력 받기
        }

        int violationCount = 0; // 위반하는 자동차 대수 초기화

        for (int number : carNumbers) {
            if (number == dateLastDigit) { // 자동차 번호의 일의 자리 숫자가 날짜의 일의 자리 숫자와 같다면
                violationCount++; // 위반 대수 증가
            }
        }

        System.out.println(violationCount); // 위반 대수 출력
    }
}
