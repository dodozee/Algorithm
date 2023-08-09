import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] digitCounts = new int[10]; // 0부터 9까지 각 숫자의 개수 저장 배열

        // 주어진 숫자를 뒤집어서 이용할 수 있는 6과 9를 제외한 나머지 숫자 개수 계산
        while (N > 0) {
            int digit = N % 10;
            if (digit == 9) {
                digitCounts[6]++;
            } else {
                digitCounts[digit]++;
            }
            N /= 10;
        }

        // 6과 9 중 더 많은 개수를 세트 수로 사용
        int maxSetCount = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                maxSetCount = Math.max(maxSetCount, (int) Math.ceil(digitCounts[i] / 2.0));
            } else {
                maxSetCount = Math.max(maxSetCount, digitCounts[i]);
            }
        }

        System.out.println(maxSetCount);

        sc.close();
    }
}
