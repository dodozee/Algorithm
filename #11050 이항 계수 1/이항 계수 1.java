import java.util.*;

public class Main{//박두지 화이팅! //갓천대 화이팅!!
    //[문제풀이]재귀적인 방식으로 구현되어 있으며, k가 0이거나 n과 같은 경우에는 1을 반환한다.
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = binomial(n, k);

        System.out.println(result);
    }

    // 이항 계수 계산 함수
    public static int binomial(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return binomial(n - 1, k - 1) + binomial(n - 1, k);
        }
    }
}