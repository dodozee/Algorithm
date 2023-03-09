import java.util.Scanner;
public class Main {
    public static void main(String[] args){ // 갓천대! 20학번 박정빈 화이팅!!!
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        int m =s.nextInt();
        
        int[] arr = new int[n];//길이 n인 배열을 생성.
        for (int i = 0; i < m; i++) {// 0부터 m번째 까지 반복한다.
            int a =s.nextInt(); //시작바구니
            int b =s.nextInt(); //끝바구니 
            int c =s.nextInt(); //뱌구니에 넣을 공의 숫자
            for (int j = a - 1; j <= b -1 ; j++) { //바구니 넣을 번호 시작과 끝을 정해주는 for문!
            arr[j]=c; //범위 정해진 c번호로 받은 공을 순서대로 넣는다.(겹쳐 쓰기)
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        s.close();
    }
}