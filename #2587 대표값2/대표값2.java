import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){ //갓천대 화이팅! 이길여 총장님 오래사세요!
        Scanner s = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }
        for (int i = 1; i < arr.length; i++) { //선택정렬...
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}
