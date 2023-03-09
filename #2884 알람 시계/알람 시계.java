import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        int hour = scan.nextInt();
        int min = scan.nextInt();
        int total = hour * 60 + min;
        int total2 = total -45;
        if(total2 < 0){
            total= 24*60+total2;
            hour = total/60;
            min = total%60;
            System.out.println(hour+ " " + min);
        }else {
            total = total -45;
            hour = total/60;
            min = total%60;
            System.out.println(hour + " " + min);
        }
    }
}