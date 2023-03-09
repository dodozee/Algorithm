import java.util.Scanner;
import java.io.*;

public class Main{ //가천대 컴공 20학번 화이팅~~
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = s.nextInt();
        }
        for (int i = 0; i < a-1; i++) { // 배열 길이는 -1해야한다. 이유는 맨마지막 배열은 검사할 필요가없다. 자기 자신이기 때문에!
            for (int j = i+1; j < a; j++) { //내부 for에서 첫번째는 고정이다.
                if(arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            System.out.println(arr[i]);
        }
    }
}