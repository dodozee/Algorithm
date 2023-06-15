import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 월 입력
        int y = sc.nextInt(); // 일 입력
        sc.close();

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 각 월의 일 수
        int totalDays = 0;

        // 입력한 월 이전 월까지의 일 수를 더함
        for (int i = 0; i < x - 1; i++) {
            totalDays += monthDays[i];
        }

        // 입력한 일 수를 더함
        totalDays += y;

        // 2007년 1월 1일은 월요일이므로, totalDays를 7로 나눈 나머지에 해당하는 요일 출력
        System.out.println(days[totalDays % 7]);
    }
}
