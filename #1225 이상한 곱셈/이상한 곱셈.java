import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] numbers = input.split(" ");
        String A = numbers[0];
        String B = numbers[1];

        long result = 0;

        for (int i = 0; i < A.length(); i++) {
            int digitA = Character.getNumericValue(A.charAt(i));
            for (int j = 0; j < B.length(); j++) {
                int digitB = Character.getNumericValue(B.charAt(j));
                result += digitA * digitB;
            }
        }

        System.out.println(result);
    }
}
