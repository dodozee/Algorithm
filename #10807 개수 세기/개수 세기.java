import java.util.Scanner;

public class Main {
    public static void main(String[] args){ //갓천대!!편입생!!화이팅!!!
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int[] arr = new int[x];//길이 x인 배열을 생성.

        for (int i = 0; i < x; i++) {// 0부터 x번째 까지 반복한다.
            arr[i] = s.nextInt();
        }

        int y = s.nextInt();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == y) {
                count++;
            }
        }
        System.out.println(count);

        s.close();
    }
}