import java.util.Scanner;
import java.io.*;
//갓천대 화이팅!//갓천대 화이팅!//갓천대 화이팅!//갓천대 화이팅!//갓천대 화이팅!//갓천대 화이팅!//갓천대 화이팅!
public class Main {
    public static void main(String[] args) throws IOException { 
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + s.nextInt(); // 2중 for문을 돌리니까 시간초과로 문제 틀렸다.
            //어차피 구간의 합이기에 배열을 넣을 처음 부터 누적으로 더해줘서 넣고
            //마지막에 앞 구간만 빼버리면된다.(그럼 뒷부분 누적구간만 나옴)
         }

        for (int i = 0; i < m; i++) {
            int start = s.nextInt();
            int end = s.nextInt();

            System.out.println(arr[end] - arr[start - 1]);
        }
    }

}