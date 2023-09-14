import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] permutation = new int[N];

        for (int i = 0; i < N; i++) {
            permutation[i] = sc.nextInt();
        }

        if (prevPermutation(permutation)) {
            for (int num : permutation) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    // 이전 순열을 구하는 함수
    public static boolean prevPermutation(int[] arr) {
        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[j] >= arr[i - 1]) {
            j--;
        }

        // arr[i-1]과 arr[j]를 스왑
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        // 스왑한 뒤에 arr[i]부터 끝까지를 뒤집음
        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
