import java.util.Scanner;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        if (input.equals("N") || input.equals("n")) {
            System.out.println("Naver D2");
        } else {
            System.out.println("Naver Whale");
        }
    }
}
