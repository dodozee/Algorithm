import java.util.*;

public class Main {//박두지 화이팅!!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong(); // 카드의 개수 입력

        // 줄바꿈 문자 처리
        scanner.nextLine();

        // 숫자 카드를 입력받아 카운트 저장
        Map<Long, Integer> countMap = new HashMap<>();
        for (long i = 0; i < n; i++) {
            long card = scanner.nextLong();
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // 가장 많이 가지고 있는 정수 찾기
        long maxCount = 0;
        long result = 0;
        for (Map.Entry<Long, Integer> entry : countMap.entrySet()) {
            long card = entry.getKey();
            long count = entry.getValue();
            if (count > maxCount || (count == maxCount && card < result)) {
                maxCount = count;
                result = card;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}