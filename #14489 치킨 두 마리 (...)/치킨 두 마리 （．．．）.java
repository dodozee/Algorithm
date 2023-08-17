import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt(); // 첫 번째 통장의 잔고
        int B = scanner.nextInt(); // 두 번째 통장의 잔고
        int C = scanner.nextInt(); // 치킨 한 마리의 가격
        
        int totalBalance = A + B; // 두 통장의 잔고 합
        
        if (totalBalance >= C * 2) { // 두 마리의 치킨을 살 수 있는 경우
            System.out.println(totalBalance - (C * 2)); // 치킨 구매 후 남은 잔고 출력
        } else { // 치킨을 살 수 없는 경우
            System.out.println(totalBalance); // 현재 잔고 출력
        }
    }
}
