import java.util.*;

public class Main { //박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 배열 정렬
        System.out.println((long)arr[0] * arr[n-1]); // 가장 작은 값과 가장 큰 값을 곱한 결과 출력
    }
}
