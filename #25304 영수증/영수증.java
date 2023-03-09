import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();


        for(int i = 1; i<=n; i++ ){
            int a = s.nextInt();
            int b = s.nextInt();
            x = x -a*b;
        }
        if(x==0){
            System.out.println("Yes");
        }else
            System.out.println("No");
    }
}