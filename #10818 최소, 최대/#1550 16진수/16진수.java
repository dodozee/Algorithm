import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 16진수 입력 받기
        String hex = scanner.nextLine();

        // 16진수를 10진수로 변환
        int decimal = Integer.parseInt(hex, 16);

        // 결과 출력
        System.out.println(decimal);
    }
}
