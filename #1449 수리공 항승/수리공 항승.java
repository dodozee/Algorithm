import java.util.Arrays;
import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 물이 새는 곳의 개수
        int L = sc.nextInt();  // 테이프의 길이
        int[] locations = new int[N];  // 물이 새는 곳의 위치

        // 물이 새는 곳의 위치 입력 받기
        for (int i = 0; i < N; i++) {
            locations[i] = sc.nextInt();
        }

        Arrays.sort(locations);  // 물이 새는 곳의 위치를 오름차순으로 정렬

        int count = 1;  // 필요한 테이프의 개수 초기화
        int start = locations[0];  // 첫 번째 물이 새는 곳의 위치로 시작점 초기화

        // 물이 새는 곳의 위치를 확인하면서 테이프를 사용하는 경우를 찾음
        for (int i = 1; i < N; i++) {
            if (locations[i] - start + 1 > L) {  // 현재 위치에서 시작점까지의 거리가 테이프 길이보다 큰 경우
                start = locations[i];  // 새로운 시작점으로 변경
                count++;  // 필요한 테이프의 개수 증가
            }
        }

        System.out.println(count);  // 결과 출력
    }
}
