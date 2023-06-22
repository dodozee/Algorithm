import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 학생 수
        int[] order = new int[n]; // 학생들이 뽑은 번호를 저장할 배열

        for (int i = 0; i < n; i++) {
            order[i] = scanner.nextInt(); // 학생들이 뽑은 번호 입력받기
        }

        int[] result = new int[n]; // 최종적으로 줄을 선 순서를 저장할 배열
        int idx = 0;

        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0; // 뽑은 번호보다 작은 번호의 개수를 세기 위한 변수

            for (int j = 0; j < n; j++) {
                if (result[j] == 0) { // 아직 번호가 부여되지 않은 경우
                    if (cnt == order[i]) { // 뽑은 번호보다 작은 번호의 개수가 같으면
                        result[j] = i + 1; // 해당 위치에 번호 부여
                        break;
                    }
                    cnt++; // 작은 번호의 개수 증가
                }
            }
        }

        for (int i = n-1; i >=0; i--) {
            System.out.print(result[i] + " "); // 결과 출력
        }
    }
}
