
import java.util.Scanner;

public class Main {
    public static void main(String[] argv){
        double A,B; //두 정수를 받을 변수
        Scanner scan = new Scanner(System.in); //객체 지정한다


        A = scan.nextDouble();
        B = scan.nextDouble();
        double c = A/B;


        System.out.println(c);



    }
}
