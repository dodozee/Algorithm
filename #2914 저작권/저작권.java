import java.util.Scanner;

public class Main {//박두지 화팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int publish = scanner.nextInt();
        int factor = scanner.nextInt(); 

        int bribe = (publish * factor) - publish + 1;
        System.out.println(bribe);
    }
}
