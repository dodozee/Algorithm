import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        Map<String, Integer> bookCounts = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String bookTitle = scanner.nextLine();

            // 이미 등록된 책이면 카운트 증가
            if (bookCounts.containsKey(bookTitle)) {
                int count = bookCounts.get(bookTitle);
                bookCounts.put(bookTitle, count + 1);
            }
            // 새로운 책이면 카운트 1로 초기화
            else {
                bookCounts.put(bookTitle, 1);
            }
        }

        // 가장 많이 팔린 책 찾기
        String bestSellingBook = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : bookCounts.entrySet()) {
            String bookTitle = entry.getKey();
            int count = entry.getValue();

            // 판매 횟수가 현재 최대값보다 크면 업데이트
            if (count > maxCount) {
                bestSellingBook = bookTitle;
                maxCount = count;
            }
            // 판매 횟수가 최대값과 같을 경우, 사전순으로 더 앞선 제목으로 업데이트
            else if (count == maxCount && bookTitle.compareTo(bestSellingBook) < 0) {
                bestSellingBook = bookTitle;
            }
        }

        System.out.println(bestSellingBook);
    }
}
