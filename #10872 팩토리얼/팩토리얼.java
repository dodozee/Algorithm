import java.util.Scanner;
public class Main { //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
//윤성우님의 열혈강의 c언어에서 배웠던게 기억나네yo ㅎㅎ..
;
    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(factorial(n));
    }
    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n*factorial(n-1);
    }

}