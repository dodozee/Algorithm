import java.util.Scanner;
import java.util.StringTokenizer;



public class Main { //갓천대 컴공 20학번 편입생들 화이팅!!!!!!!

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int [] num = new int [30];

        for(int i = 0; i < 30; i++){
            num[i] = 0; //우선 모든 30명 학생들에게 0을 넣는다.
        }

        for(int i = 0; i < 28; i++) {
            int n = sc.nextInt(); // 무작위로 출석한 학생들을 입력한다.
            num[n-1] = 1;
        }

        for(int i = 0; i < 30; i++){
            if(num[i] != 1){ //1이 아닌애들을 걸러낸다.
                System.out.println(i+1); 
            }
        }
    }
}