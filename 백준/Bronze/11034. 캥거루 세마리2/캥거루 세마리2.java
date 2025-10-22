import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while(true){
            try{
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();

                System.out.println(Math.max(b-a-1,c-b-1));
            }catch (Exception e){
                break;
            }
        }
    }
}