import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[x];//길이 x인 배열을 생성.

        for (int i = 0; i < x; i++) {// 0부터 x번째 까지 반복한다.
            arr[i] = s.nextInt();
        }


        int count = 0; // 찾는 숫자 카운터 셀 변수 선언

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < k) {
                count++;
            }
        }
        int[] arr2 = new int[count];//길이가 필터링되어 count만한 배열을 선언! 이사갈 준비!
        int count2 = 0; //이름 arr2 새로운 배열에 넣을 index값을 위해 0으로 초기화!
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < k) {
                arr2[count2] = arr[i];
                count2++;
            }
        }

        for(int i =0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }

        s.close();
    }
}