import java.util.Scanner;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] count = new int[10];
        String result = String.valueOf(a * b * c);
        for (int i = 0; i < result.length(); i++) {
            int num = result.charAt(i) - '0';
            count[num]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }
}
