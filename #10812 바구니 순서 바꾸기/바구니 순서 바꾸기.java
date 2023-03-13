import java.io.*;
import java.util.StringTokenizer;


public class Main {//갓천댓~~ 두지코딩~~
    public static void main(String args[]) throws Exception {
        //솔직히 너무 나만 알아보게 코드를 짜놔서 0점이다..
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());

            rotate(arr, begin, mid, end);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    //여기가 정말 가관이다... 코드가 개떡이다. 설명을 하자면 앞 뒤 바꿀부분을 임시 저장 배열을 선언한뒤 서로 앞뒤 바꿔서 붙혔다.
    //로직은 매우 말로도 설명쉽게 간단한데...구간 같은 부분이 개떡이다
   static void rotate(int[] arr ,int begin, int mid, int end) {
       int[] rotate1_arr = new int[mid-begin]; //앞놈 크기 2
       int[] rotate2_arr = new int[end-(mid-1)]; //뒷놈 크기 3


       for (int i = mid-1; i < mid-1+rotate2_arr.length; i++) { //mid부터 end까지 담을 배열
           rotate2_arr[i-(mid-1)] = arr[i];
       }

       for (int i = begin-1; i < mid - 1; i++) { //begin부터 mid-1까지
           rotate1_arr[i-(begin-1)] = arr[i];
       }

       for (int i = begin-1+rotate2_arr.length; i < begin-1+rotate2_arr.length +rotate1_arr.length; i++) { // 원래 배열에 붙히는 과정. mid~end를 앞으로 보내는 중이다.
           arr[i] = rotate1_arr[i-( begin-1+rotate2_arr.length)];
       }

       for (int i = begin-1; i <begin-1+rotate2_arr.length; i++) {// 원래 배열에 붙히는 과정. begin~mid를 뒤로 보내는 중이다.
           arr[i] = rotate2_arr[i-(begin-1)];
       }


    }
}