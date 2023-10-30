import java.util.Scanner;
public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(Math.min(a + d, b + c));
    }
}