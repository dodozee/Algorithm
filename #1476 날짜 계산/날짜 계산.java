import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int E = scanner.nextInt();  // 지구 수 입력
        int S = scanner.nextInt();  // 태양 수 입력
        int M = scanner.nextInt();  // 달 수 입력

        int year = 1;  // 시작 연도를 1로 설정

        // 주어진 조건에 맞는 연도를 찾기 위해 반복
        while (true) {
            // 현재 연도의 지구, 태양, 달 수를 계산
            int currE = (year - 1) % 15 + 1;
            int currS = (year - 1) % 28 + 1;
            int currM = (year - 1) % 19 + 1;

            // 주어진 수와 현재 연도의 수가 일치하면 해당 연도를 출력하고 반복 종료
            if (currE == E && currS == S && currM == M) {
                System.out.println(year);
                break;
            }

            year++;  // 연도를 1 증가시킴
        }
    }
}
