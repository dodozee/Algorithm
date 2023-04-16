import java.util.*;

public class Main{ //박두지 화이팅!!! 갓천대 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int gcd = gcd(a, b);// 최대공약수 메서드 호출

            int lcm = (a * b)/gcd;

            System.out.println(lcm);

        }
    }

    private static int gcd(int a, int b) { //최대 공약수를 구하는 메서드
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}