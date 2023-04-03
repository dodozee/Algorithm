import java.util.*;

public class Main {//박두지 화이팅!!! 갓천대 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 고정 비용
        int B = sc.nextInt(); // 가변 비용
        int C = sc.nextInt(); // 노트북 가격

        int breakEvenPoint = 0; // 손익분기점

        if (C <= B) { // 노트북 가격이 가변 비용보다 작으면 이익이 나올 수 없음
            breakEvenPoint = -1;
        } else {
            breakEvenPoint = A / (C - B) + 1; // 최초로 이익이 발생하는 판매량 계산
        }

        System.out.println(breakEvenPoint);
        sc.close();
    }
}