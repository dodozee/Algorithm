import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        int hour = scan.nextInt();
        int min = scan.nextInt();
        int plus = scan.nextInt();
        int total = hour * 60 + min + plus;
        if(total/60>=24){
            total = total - 24 * 60;
            hour = total / 60;
            min = total % 60;
            System.out.println(hour+ " " + min);
        }else {
            hour = total/60;
            min = total%60;
            System.out.println(hour + " " + min);
        }
    }
}
