import java.util.Scanner;

public class Main {//박두지 화이팅
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 10권의 총 가격 입력
        int total = scanner.nextInt();

        // 9개의 책 가격 입력 및 총 가격 계산
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int price = scanner.nextInt();
            sum += price;
        }

        // 가격을 읽을 수 없는 책의 가격 계산 및 출력
        int unreadableBookPrice = total - sum;
        System.out.println(unreadableBookPrice);

        scanner.close();
    }
}
