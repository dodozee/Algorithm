import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int B = sc.nextInt();
        sc.close();

        String result = convertToBaseB(N, B);
        System.out.println(result);
    }

    public static String convertToBaseB(long N, int B) {
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            long remainder = N % B;
            char digit;
            
            if (remainder >= 10) {
                // 숫자가 10 이상이면 알파벳으로 표현
                digit = (char) ('A' + remainder - 10);
            } else {
                // 그 외에는 숫자 그대로 사용
                digit = (char) ('0' + remainder);
            }

            sb.insert(0, digit); // 가장 뒤에 삽입
            N /= B;
        }

        return sb.toString();
    }
}
