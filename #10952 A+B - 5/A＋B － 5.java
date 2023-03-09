import java.util.Scanner;
public class Main {

    public static void main(String[] args){ //가천대 컴공 화이팅!!!!!!!화성갈끄니이까아안!!
        Scanner s = new Scanner(System.in);
             while(true) {
                 int a = s.nextInt();
                 int b = s.nextInt();
                 if(a==0 && b==0){
                     break;
                 }
                 System.out.println(a + b);
             }
             s.close();
    }
}