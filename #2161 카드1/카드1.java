import java.io.*;
import java.util.Arrays;

public class Main {//갓천댓~~ 두지코딩~~
    public static void main(String args[]) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder(); //StringBuilder는 객체를 생성하고 append()메서드를 사용하면 chain 방식으로 문자열을 추가한다.

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=1; i < n+1; i++){
            arr[i-1] = i;
        }

        for (int i = 0; i < n; i++) {
           arr= pop(arr);
        }

    }

    static int[] pop(int[] arr) {
        System.out.print(arr[0] + " "); //맨 앞 카드 출력!
        int new_arr[] = new int[arr.length]; //임시로 담을 배열 생성(swap 할 때 temp같은 존재)
        for (int i = 1; i < arr.length; i++) {
            new_arr[i - 1] = arr[i]; //새로운 배열로 이사중! 이사하는 이유는 한칸씩 앞으로 배열을 옮기기 위해서이다
        }
        new_arr[new_arr.length - 1] = new_arr[0]; //맨 윗장에 있던 카드를 배열 맨뒤로 옮긴다.
        int new_arr_2[] = new int[arr.length - 1]; //배열 크기가 n이면 n-1크기 배열로 줄이기 위해 이사할 배열 생성
        for (int i = 1; i < new_arr.length; i++) {
            new_arr_2[i - 1] = new_arr[i]; // 새로운 배열로 이사!
        }
    return new_arr_2; // 한 rotation이 돌고나면 반환한다. 그리고 for문으로 무한 반복.
    }
}