import java.io.*;
import java.util.Scanner;
public class Main { //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!! 지금 새벽4시... 잠에서 꺤지 26시간째
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        String[] arr = s.split(" ");
        int[] arr_int = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr_int[i] = Integer.parseInt(arr[i]);
        }

        int[] ches1 = {1, 1, 2, 2, 2, 8};
        int[] result = {0, 0, 0, 0, 0, 0}; //0으로 초기화된 깨끗한 정수형 배열
        for (int i = 0; i < 6; i++) {
           ches1[i] = ches1[i] - arr_int[i];
           result[i]=ches1[i];
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(result[i] + " ");
        }
    }
}