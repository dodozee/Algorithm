import java.util.Scanner;

public class Main { //박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 자연수 N 입력 받기
        long N = scanner.nextLong();

        String binaryRepresentation = convertToBinary(N);
        System.out.println(binaryRepresentation);

        scanner.close();
    }

    private static String convertToBinary(long N) {
        StringBuilder binary = new StringBuilder();

        if (N == 0) {
            return "0";
        }

        while (N > 0) {
            long remainder = N % 2;
            binary.insert(0, remainder); 
            N /= 2;
        }

        return binary.toString();
    }
}
