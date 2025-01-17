import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Antena = sc.nextInt();
        int eyes = sc.nextInt();

        if (Antena >= 3 && eyes <=4){
            System.out.println("TroyMartian");
        }if(Antena <= 6 && eyes >= 2 ){
            System.out.println("VladSaturnian");
        }if(Antena <=2 && eyes <= 3){
            System.out.println("GraemeMercurian");
        }else {

        }

    }
}