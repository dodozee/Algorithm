import java.util.*;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int count =0;

        while(N>=2 && M>=1 && M+N >=3+K){
            N = N-2;
            M= M-1;
            count++;
        }
        System.out.println(count);
    }
}