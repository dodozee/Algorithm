import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] tallerCount = new int[N];
        int[] line = new int[N];

        // 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 입력받음
        for (int i = 0; i < N; i++) {
            tallerCount[i] = sc.nextInt();
        }

        // 빈 자리에 키를 채움
        for (int i = 0; i < N; i++) {
            int count = 0; // 왼쪽에 있는 더 큰 사람의 수
            for (int j = 0; j < N; j++) {
                if (line[j] == 0) { // 빈 자리인 경우
                    if (count == tallerCount[i]) { // 왼쪽에 있는 더 큰 사람의 수가 일치하면
                        line[j] = i + 1; // 해당 위치에 i+1 번째 키를 배치
                        break;
                    }
                    count++;
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
    }
}
