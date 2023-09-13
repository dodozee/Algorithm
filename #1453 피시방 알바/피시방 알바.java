import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 손님의 수
        int[] seats = new int[100]; // 컴퓨터 자리 배열 (0: 빈 자리, 1: 차있는 자리)

        int rejectedCount = 0; // 거절당하는 손님의 수

        for (int i = 0; i < n; i++) {
            int wantedSeat = sc.nextInt(); // 손님이 앉고 싶어하는 자리 번호

            if (seats[wantedSeat - 1] == 0) {
                seats[wantedSeat - 1] = 1; // 자리가 비어있으면 손님이 앉음
            } else {
                rejectedCount++; // 자리가 이미 차있으면 거절
            }
        }

        System.out.println(rejectedCount);
    }
}
