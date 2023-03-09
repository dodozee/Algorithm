import java.util.Scanner;


public class Main {
    public static void main(String[] args){ //갓천대! 20학번! 컴공! 박정빈!화이팅!!
        Scanner s = new Scanner(System.in);
        int[] arr = new int[9];//길이 x인 배열을 생성.

        for (int i = 0; i < 9; i++) {// 0부터 x번째 까지 반복한다.
            arr[i] = s.nextInt();
        }
        int max = arr[0];
        int index = 0; // 배열 몇번째인지 알라고 인덱스 변수 선언
        for(int i = 0; i < 9; i++){
            if(arr[i]>max){
                max = arr[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.print(index+1); // 배열은 0부터 시작하기때문에 순서를 세려면 +1해야한다.


        s.close();
    }
}