import java.util.*;

public class Main { //갓천대!!!포에버!! 나라사랑가천사랑동기사랑
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 상근이가 가지고 있는 숫자 카드의 개수
        int[] cards = new int[n]; // 숫자 카드 배열
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }
        Arrays.sort(cards); // 이진 탐색을 위한 정렬

        int m = sc.nextInt(); // 구해야 할 숫자 카드의 개수
        int[] nums = new int[m]; // 구해야 할 숫자 카드 배열
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int target = nums[i]; // 구해야 할 숫자 카드
            int left = 0; // 이진 탐색을 위한 시작 인덱스
            int right = n - 1; // 이진 탐색을 위한 끝 인덱스
            boolean found = false; // 숫자 카드를 찾았는지 여부

            while (left <= right) {
                int mid = (left + right) / 2; // 중간 인덱스
                if (cards[mid] == target) { // 숫자 카드를 찾은 경우
                    found = true;
                    break;
                } else if (cards[mid] > target) { // 찾으려는 숫자 카드가 중간 값보다 작은 경우
                    right = mid - 1;
                } else { // 찾으려는 숫자 카드가 중간 값보다 큰 경우
                    left = mid + 1;
                }
            }

            if (found) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}