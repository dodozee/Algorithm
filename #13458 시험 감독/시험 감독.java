import java.util.Scanner;

public class Main {//박두지화이팅!! 네카라쿠배 가즈아!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 시험장의 개수
        int[] a = new int[n]; // 각 시험장의 응시자 수
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int b = scanner.nextInt(); // 총감독관이 감시 가능한 응시자 수
        int c = scanner.nextInt(); // 부감독관이 감시 가능한 응시자 수

        long answer = 0; // 필요한 감독관의 수
        for (int i = 0; i < n; i++) {
            // 총감독관이 감시할 수 있는 응시자 수보다 적은 경우
            if (a[i] <= b) {
                answer++;
            } else {
                answer++; // 총감독관은 반드시 1명 필요하므로 1 추가
                // 부감독관이 필요한 경우
                answer += (a[i] - b - 1) / c + 1;
            }
        }

        System.out.println(answer);
    }
}
