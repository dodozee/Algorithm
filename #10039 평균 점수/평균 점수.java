import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int score = scanner.nextInt();
            sum += Math.max(score, 40);
        }

        int average = sum / 5;
        System.out.println(average);
    }
}
