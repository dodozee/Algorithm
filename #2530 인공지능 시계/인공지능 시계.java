import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 현재 시각 입력 받기
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // 요리하는 데 필요한 시간 입력 받기
        int d = scanner.nextInt();

        // 총 걸리는 시간 계산 (초 단위)
        int total = (a * 3600 + b * 60 + c + d) % (24 * 3600);

        // 시, 분, 초 단위로 변환
        int hour = total / 3600;
        int minute = (total % 3600) / 60;
        int second = total % 60;

        // 출력
        System.out.println(hour + " " + minute + " " + second);

        scanner.close();
    }
}
