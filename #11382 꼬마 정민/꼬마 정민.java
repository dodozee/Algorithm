import java.util.Scanner;

public class Main {
  public static void main(String[] argv){

        Scanner scan = new Scanner(System.in); //객체 지정한다
        long A = scan.nextLong();
        long B = scan.nextLong();
        long C = scan.nextLong();

        scan.close();

        System.out.println(A+B+C);

  }
}

