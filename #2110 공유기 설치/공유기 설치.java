import java.util.*;

public class Main {/**박두지 화이팅!!! 갓천대 화이팅!!!
 [문제 풀이]
 1.먼저, 집의 개수와 공유기 개수를 받는다. 그 다음 집의 좌표를 입력 받고 오름차순으로 정렬
 2.start를 1로 하고 end를 제일 먼집과 가장 가까운 집 사이의 거리로 초기화
 3.이분탐색을 하기 위해 중간값인 mid를 구하고 mid 이상의 거리를 두고 공유기를 설치할 수 있는 경우의 수(count)를 센다
 4.설치한 공유기의 개수가 c이상인 경우에만 mid 값을 기록하고 start 값을 증가 시킨다.
 5.설치한 공유기의 개수가 c미만일 경우에는 end 값을 감소시킨다.
 
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1] - arr[0];

        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int prev = arr[0];

            for (int i = 1; i < n; i++) {
                int distance = arr[i] - prev;
                if (distance >= mid) {
                    count++;
                    prev = arr[i];
                }
            }

            if (count >= c) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
