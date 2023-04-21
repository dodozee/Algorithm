import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuNum = 1; // 메뉴 번호
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break; // 입력이 끝날 때까지 반복
            int bestD = 0;
            double bestCost = Double.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int diameter = sc.nextInt();
                int price = sc.nextInt();
                double cost = price / (Math.PI * Math.pow(diameter/2.0, 2)); // 면적당 비용 계산
                if (cost < bestCost) { // 최소값 업데이트
                    bestCost = cost;
                    bestD = diameter;
                }
            }
            System.out.printf("Menu %d: %d\n", menuNum, bestD); // 출력
            menuNum++;
        }
        sc.close();
    }
}
