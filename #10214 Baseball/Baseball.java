import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수
        
        for (int t = 0; t < T; t++) {
            int YonseiScore = 0;
            int KoreaScore = 0;
            
            for (int i = 0; i < 9; i++) {
                int Y = sc.nextInt(); // 연세대 득점
                int K = sc.nextInt(); // 고려대 득점
                
                YonseiScore += Y;
                KoreaScore += K;
            }
            
            if (YonseiScore > KoreaScore) {
                System.out.println("Yonsei");
            } else if (YonseiScore < KoreaScore) {
                System.out.println("Korea");
            } else {
                System.out.println("Draw");
            }
        }
        
        sc.close();
    }
}
