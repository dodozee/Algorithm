import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();//테스트 개수 T입력한다~~~
        for(int i=1; i<=t; i++) {

            int a = scan.nextInt();//밑 a를 가져온다!!
            int b = scan.nextInt();//지수 b를 가져온다!!

            int result = look(a, b);
            System.out.println(result);

        }
        }
    static int look(int a, int b){
        int value = 1;
        int count =0 ;
        if(a%10 ==0 || a %10==1 || a %10 ==5 || a%10 == 6){// 밑이 1,5,6,10은 거듭제곱해도 반복되는 1의 자리수의 숫자가 나온다.
        value = a%10;
        }else if(a%10 ==4 || a%10 == 9){ // 1의 자리수의 나머지가 4 또는 9가 나오는 경우는 짝,홀로 번갈아가면서 제곱들의 뒷자리가 같다.
            count = b%2; //홀짝구하는중
            if(count ==0) //짝수일경우엔 
                count = 2; 

        }else { //그외 나머지 2,3,7,8은 지수의 4의 간격마다 똑같은 숫자가 돌고 돈다.
            count = b % 4; //간격대로의 나머지를 구한다.
            if (count == 0) {
                count = 4;
            }
        }
            for(int i=0; i<count;i++){
                value =(value * a)%10; // 매 1의 자리수와 a와 자꾸 곱할수 있는 로직
            }
            if(value ==0){ //0이라는 것은 10번째 컴퓨터라는 뜻.
                value =10;
            }
    return value; //value 반환
    }
}
