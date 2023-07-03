import java.util.Scanner;

public class Main { //두두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        
        String binary = Integer.toBinaryString(N); // N을 2진법으로 변환
        StringBuilder reversedBinary = new StringBuilder(binary).reverse(); // 2진법을 뒤집음
        
        int result = Integer.parseInt(reversedBinary.toString(), 2); // 뒤집힌 2진법을 10진법으로 변환
        
        System.out.println(result);
    }
}
