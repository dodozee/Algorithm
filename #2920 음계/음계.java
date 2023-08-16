import java.util.Scanner;

public class Main {//박두지 화이팅1!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = new int[8];

        for (int i = 0; i < 8; i++) {
            sequence[i] = scanner.nextInt();
        }

        if (isAscending(sequence)) {
            System.out.println("ascending");
        } else if (isDescending(sequence)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }

    public static boolean isAscending(int[] sequence) {
        for (int i = 0; i < 7; i++) {
            if (sequence[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDescending(int[] sequence) {
        for (int i = 0; i < 7; i++) {
            if (sequence[i] != 8 - i) {
                return false;
            }
        }
        return true;
    }
}
