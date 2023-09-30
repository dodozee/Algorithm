import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 재환이가 낼 수 있는 "aaah"와 의사가 요구하는 "aah"를 입력 받습니다.
        String jaehwanAah = scanner.nextLine();
        String doctorAah = scanner.nextLine();

        // 재환이의 "aaah"의 길이와 의사의 "aah"의 길이를 비교하여 결정합니다.
        if (jaehwanAah.length() >= doctorAah.length()) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }

        scanner.close();
    }
}
