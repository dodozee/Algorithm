import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException { //갓천대 화이팅!
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // 몇 개의 카드를 선택할지 입력
        int m = s.nextInt(); // 기준 값 설정
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
//            System.out.print(arr[i] + " "); //log
        }
        int max =0;
        int max2;
        for (int i = 0; i < n; i++) {
            for(int j =i +1; j<n; j++){
                for(int k =j+1;k<n;k++){
                    max2=arr[i]+arr[j]+arr[k];
                    if(max2<= m && max<max2){
                        max=max2;
//                            System.out.print("선택중 i: " + arr[i] + " j: "+ arr[j] + " k: " + arr[k]+ "\n \n"); //log
                    }
                }
            }
        }
        System.out.println(max);
    }

}