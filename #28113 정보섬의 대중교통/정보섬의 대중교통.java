import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int A=s.nextInt();
        int B=s.nextInt();
        if(B>A){
            System.out.println("Bus");
        }
        else if(B<A){
            System.out.println("Subway");
        }else{
            System.out.println("Anything");
        }
    }
}