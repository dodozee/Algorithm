import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt(); // 햄버거 빵의 개수
        int b = scanner.nextInt(); // 햄버거 패티의 개수

        a/=2;
        System.out.println(a<b?a:b);
       
    }
}
