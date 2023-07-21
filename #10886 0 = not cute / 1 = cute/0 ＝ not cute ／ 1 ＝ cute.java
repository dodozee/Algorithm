import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int cuteCount = 0;
        int notCuteCount = 0;

        for (int i = 0; i < n; i++) {
            int opinion = scanner.nextInt();
            if (opinion == 0) {
                notCuteCount++;
            } else {
                cuteCount++;
            }
        }

        if (cuteCount > notCuteCount) {
            System.out.println("Junhee is cute!");
        } else {
            System.out.println("Junhee is not cute!");
        }
    }
}
