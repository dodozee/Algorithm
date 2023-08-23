import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int sum = calculateSum(input);
        System.out.println(sum);
    }

    public static int calculateSum(String s) {
        String[] numbers = s.split(",");
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
