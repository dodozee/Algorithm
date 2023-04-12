import java.util.Scanner;

public class Main {//박두지 화이팅!!!! 갓천대 화이팅!!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        N = N / 100 * 100; // 뒤 두 자리를 0으로 만들기 위해 100으로 나눈 뒤 100을 곱함
        while (N % F != 0) { // F로 나누어 떨어질 때까지 뒤 두 자리를 하나씩 증가시킴
            N++;
        }

        int answer = N % 100; // 뒤 두 자리만 추출
        if (answer < 10) { // 두 자리가 아니라면 앞에 0을 추가함
            System.out.println("0" + answer);
        } else {
            System.out.println(answer);
        }
    }
}
