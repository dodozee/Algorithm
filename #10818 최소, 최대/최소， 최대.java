import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int[] arr = new int[x];//길이 x인 배열을 생성.

        for (int i = 0; i < x; i++) {// 0부터 x번째 까지 반복한다.
            arr[i] = s.nextInt();
        }
        int min = arr[0];
        int max = arr[0];
        for(int i = 0; i < x; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        for(int i = 0; i < x; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(min + " " + max);
        
        s.close();
    }
}